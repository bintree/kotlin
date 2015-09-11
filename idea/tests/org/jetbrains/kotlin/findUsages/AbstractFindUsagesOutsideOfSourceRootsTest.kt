/*
 * Copyright 2010-2015 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.findUsages

import com.intellij.openapi.roots.ModuleRootModificationUtil
import com.intellij.openapi.roots.OrderRootType
import com.intellij.openapi.roots.libraries.LibraryUtil
import com.intellij.openapi.util.io.FileUtil
import com.intellij.openapi.vfs.VfsUtil
import com.intellij.psi.PsiElement
import com.intellij.testFramework.PlatformTestCase
import com.intellij.testFramework.UsefulTestCase
import org.jetbrains.kotlin.idea.test.ConfigLibraryUtil
import org.jetbrains.kotlin.idea.util.application.runWriteAction
import org.jetbrains.kotlin.test.InTextDirectivesUtils
import org.jetbrains.kotlin.test.JUnit3RunnerWithInners
import org.jetbrains.kotlin.test.JetTestUtils
import org.junit.runner.RunWith
import java.io.File

@RunWith(JUnit3RunnerWithInners::class)
public open class AbstractFindUsagesOutsideOfSourceRootsTest : AbstractJetFindUsagesTest() {
    public class NonSourceRootTest : AbstractFindUsagesOutsideOfSourceRootsTest() {
        public fun testMethod() {
            val path = JetTestUtils.navigationMetadata("idea/testData/findUsages/outsideOfSourceRoots/Method.java")
            doTestOutsideOfSourceRoots(path)
        }

        public fun testField() {
            val path = JetTestUtils.navigationMetadata("idea/testData/findUsages/outsideOfSourceRoots/Field.java")
            doTestOutsideOfSourceRoots(path)
        }

        public fun testClass() {
            val path = JetTestUtils.navigationMetadata("idea/testData/findUsages/outsideOfSourceRoots/Class.java")
            doTestOutsideOfSourceRoots(path)
        }

        override fun tearDown() {
            runWriteAction {
                myFixture?.file?.delete()
            }

            super.tearDown()
        }

        protected fun doTestOutsideOfSourceRoots(path: String) {
            val file = myFixture.copyFileToProject(path, "../Tmp.java")
            myFixture.configureFromExistingVirtualFile(file)

            doTestWithConfiguredFile(path)
        }
    }

    public class SourceRootInLibraryWithNoClassesTest : AbstractFindUsagesOutsideOfSourceRootsTest() {
        public fun testMethod() {
            val path = JetTestUtils.navigationMetadata("idea/testData/findUsages/outsideOfSourceRoots/Method.java")
            doTestInLibrarySourceWithNoClassFiles(path)
        }

        public fun testField() {
            val path = JetTestUtils.navigationMetadata("idea/testData/findUsages/outsideOfSourceRoots/Field.java")
            doTestInLibrarySourceWithNoClassFiles(path)
        }

        public fun testClass() {
            val path = JetTestUtils.navigationMetadata("idea/testData/findUsages/outsideOfSourceRoots/Class.java")
            doTestInLibrarySourceWithNoClassFiles(path)
        }

        override fun tearDown() {
            runWriteAction {
                ConfigLibraryUtil.removeLibrary(myModule, "myLib")
            }

            super.tearDown()
        }

        protected fun doTestInLibrarySourceWithNoClassFiles(path: String) {
            val file = File(path)
            val tmpDir = PlatformTestCase.createTempDir("myLib")
            FileUtil.copy(file, File(tmpDir, file.name))

            ModuleRootModificationUtil.addModuleLibrary(
                    myModule, "myLib",
                    /* no classes roots */listOf(),
                    /* source roots */ listOf(VfsUtil.getUrlForLibraryRoot(tmpDir))
            )

            val vFile = LibraryUtil.findLibrary(myModule, "myLib")!!.getFiles(OrderRootType.SOURCES)[0].findChild(file.name)!!
            myFixture.configureFromExistingVirtualFile(vFile)

            doTestWithConfiguredFile(path)
        }
    }

    protected fun doTestWithConfiguredFile(path: String) {
        val mainFile = File(path)
        val mainFileName = mainFile.getName()
        val mainFileText = FileUtil.loadFile(mainFile, true)
        val prefix = mainFileName.substring(0, mainFileName.indexOf('.') + 1)

        val caretElementClassNames = InTextDirectivesUtils.findLinesWithPrefixesRemoved(mainFileText, "// PSI_ELEMENT: ")
        assert(caretElementClassNames.size() == 1)

        @Suppress("UNCHECKED_CAST")
        val parser = AbstractJetFindUsagesTest.OptionsParser.getParserByPsiElementClass(Class.forName(caretElementClassNames.get(0)) as Class<out PsiElement>)

        val rootPath = path.substring(0, path.lastIndexOf("/") + 1)

        val caretElement = myFixture.elementAtCaret

        UsefulTestCase.assertInstanceOf(caretElement, Class.forName(caretElementClassNames.get(0)))

        val options = parser?.parse(mainFileText, project)

        findUsagesAndCheckResults(mainFileText, prefix, rootPath, caretElement, options)
    }
}
