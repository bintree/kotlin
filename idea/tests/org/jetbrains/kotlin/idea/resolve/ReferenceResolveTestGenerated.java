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

package org.jetbrains.kotlin.idea.resolve;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.InnerTestClasses;
import org.jetbrains.kotlin.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.test.JetTestUtils;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("idea/testData/resolve/references")
@TestDataPath("$PROJECT_ROOT")
@InnerTestClasses({
        ReferenceResolveTestGenerated.DelegatedPropertyAccessors.class,
        ReferenceResolveTestGenerated.ForLoopIn.class,
        ReferenceResolveTestGenerated.Invoke.class,
})
@RunWith(JUnit3RunnerWithInners.class)
public class ReferenceResolveTestGenerated extends AbstractReferenceResolveTest {
    public void testAllFilesPresentInReferences() throws Exception {
        JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/resolve/references"), Pattern.compile("^([^\\.]+)\\.kt$"), true);
    }

    @TestMetadata("AnnotationForClass.kt")
    public void testAnnotationForClass() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/AnnotationForClass.kt");
        doTest(fileName);
    }

    @TestMetadata("AnnotationInsideFunction.kt")
    public void testAnnotationInsideFunction() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/AnnotationInsideFunction.kt");
        doTest(fileName);
    }

    @TestMetadata("AnnotationOnFile.kt")
    public void testAnnotationOnFile() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/AnnotationOnFile.kt");
        doTest(fileName);
    }

    @TestMetadata("AnnotationOnFileWithImport.kt")
    public void testAnnotationOnFileWithImport() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/AnnotationOnFileWithImport.kt");
        doTest(fileName);
    }

    @TestMetadata("AnnotationParameter.kt")
    public void testAnnotationParameter() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/AnnotationParameter.kt");
        doTest(fileName);
    }

    @TestMetadata("AnnotationTypeParameter.kt")
    public void testAnnotationTypeParameter() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/AnnotationTypeParameter.kt");
        doTest(fileName);
    }

    @TestMetadata("ClassInTypeConstraint.kt")
    public void testClassInTypeConstraint() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/ClassInTypeConstraint.kt");
        doTest(fileName);
    }

    @TestMetadata("ClassObjectClassLiteralReference.kt")
    public void testClassObjectClassLiteralReference() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/ClassObjectClassLiteralReference.kt");
        doTest(fileName);
    }

    @TestMetadata("ClassObjectClassLiteralReferenceWithField.kt")
    public void testClassObjectClassLiteralReferenceWithField() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/ClassObjectClassLiteralReferenceWithField.kt");
        doTest(fileName);
    }

    @TestMetadata("ClassQualifierForNestedClassConstructorCall.kt")
    public void testClassQualifierForNestedClassConstructorCall() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/ClassQualifierForNestedClassConstructorCall.kt");
        doTest(fileName);
    }

    @TestMetadata("ClassReferenceInImport.kt")
    public void testClassReferenceInImport() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/ClassReferenceInImport.kt");
        doTest(fileName);
    }

    @TestMetadata("CtrlClickResolve.kt")
    public void testCtrlClickResolve() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/CtrlClickResolve.kt");
        doTest(fileName);
    }

    @TestMetadata("DataClassCopy.kt")
    public void testDataClassCopy() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/DataClassCopy.kt");
        doTest(fileName);
    }

    @TestMetadata("DefaultObjectAsExtensionReceiverForFunction.kt")
    public void testDefaultObjectAsExtensionReceiverForFunction() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/DefaultObjectAsExtensionReceiverForFunction.kt");
        doTest(fileName);
    }

    @TestMetadata("DefaultObjectAsExtensionReceiverForProperty.kt")
    public void testDefaultObjectAsExtensionReceiverForProperty() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/DefaultObjectAsExtensionReceiverForProperty.kt");
        doTest(fileName);
    }

    @TestMetadata("DefaultObjectAsReceiverForExtensionFunctionOnSuperType.kt")
    public void testDefaultObjectAsReceiverForExtensionFunctionOnSuperType() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/DefaultObjectAsReceiverForExtensionFunctionOnSuperType.kt");
        doTest(fileName);
    }

    @TestMetadata("DefaultObjectAsReceiverForMemberPropertyInSuperType.kt")
    public void testDefaultObjectAsReceiverForMemberPropertyInSuperType() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/DefaultObjectAsReceiverForMemberPropertyInSuperType.kt");
        doTest(fileName);
    }

    @TestMetadata("DefaultObjectInShortReferenceFormCall.kt")
    public void testDefaultObjectInShortReferenceFormCall() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/DefaultObjectInShortReferenceFormCall.kt");
        doTest(fileName);
    }

    @TestMetadata("EnumValues.kt")
    public void testEnumValues() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/EnumValues.kt");
        doTest(fileName);
    }

    @TestMetadata("FakeJavaLang1.kt")
    public void testFakeJavaLang1() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/FakeJavaLang1.kt");
        doTest(fileName);
    }

    @TestMetadata("FakeJavaLang2.kt")
    public void testFakeJavaLang2() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/FakeJavaLang2.kt");
        doTest(fileName);
    }

    @TestMetadata("FakeJavaLang3.kt")
    public void testFakeJavaLang3() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/FakeJavaLang3.kt");
        doTest(fileName);
    }

    @TestMetadata("FakeJavaLang4.kt")
    public void testFakeJavaLang4() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/FakeJavaLang4.kt");
        doTest(fileName);
    }

    @TestMetadata("GenericFunctionParameter.kt")
    public void testGenericFunctionParameter() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/GenericFunctionParameter.kt");
        doTest(fileName);
    }

    @TestMetadata("GenericTypeInFunctionParameter.kt")
    public void testGenericTypeInFunctionParameter() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/GenericTypeInFunctionParameter.kt");
        doTest(fileName);
    }

    @TestMetadata("ImportFromRootScope.kt")
    public void testImportFromRootScope() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/ImportFromRootScope.kt");
        doTest(fileName);
    }

    @TestMetadata("InClassParameter.kt")
    public void testInClassParameter() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/InClassParameter.kt");
        doTest(fileName);
    }

    @TestMetadata("InClassParameterField.kt")
    public void testInClassParameterField() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/InClassParameterField.kt");
        doTest(fileName);
    }

    @TestMetadata("InFunctionParameterType.kt")
    public void testInFunctionParameterType() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/InFunctionParameterType.kt");
        doTest(fileName);
    }

    @TestMetadata("InMethodParameter.kt")
    public void testInMethodParameter() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/InMethodParameter.kt");
        doTest(fileName);
    }

    @TestMetadata("InObjectClassObject.kt")
    public void testInObjectClassObject() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/InObjectClassObject.kt");
        doTest(fileName);
    }

    @TestMetadata("InSecondClassObject.kt")
    public void testInSecondClassObject() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/InSecondClassObject.kt");
        doTest(fileName);
    }

    @TestMetadata("JavaAnnotationParameter.kt")
    public void testJavaAnnotationParameter() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/JavaAnnotationParameter.kt");
        doTest(fileName);
    }

    @TestMetadata("JavaEnumEntry.kt")
    public void testJavaEnumEntry() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/JavaEnumEntry.kt");
        doTest(fileName);
    }

    @TestMetadata("JavaEnumValueOf.kt")
    public void testJavaEnumValueOf() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/JavaEnumValueOf.kt");
        doTest(fileName);
    }

    @TestMetadata("JavaParameter.kt")
    public void testJavaParameter() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/JavaParameter.kt");
        doTest(fileName);
    }

    @TestMetadata("JavaReference.kt")
    public void testJavaReference() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/JavaReference.kt");
        doTest(fileName);
    }

    @TestMetadata("MultiDeclarationExtension.kt")
    public void testMultiDeclarationExtension() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/MultiDeclarationExtension.kt");
        doTest(fileName);
    }

    @TestMetadata("MultiDeclarationMember.kt")
    public void testMultiDeclarationMember() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/MultiDeclarationMember.kt");
        doTest(fileName);
    }

    @TestMetadata("NamedClassObject.kt")
    public void testNamedClassObject() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/NamedClassObject.kt");
        doTest(fileName);
    }

    @TestMetadata("PackageReference.kt")
    public void testPackageReference() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/PackageReference.kt");
        doTest(fileName);
    }

    @TestMetadata("PackageReferenceInImport.kt")
    public void testPackageReferenceInImport() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/PackageReferenceInImport.kt");
        doTest(fileName);
    }

    @TestMetadata("PropertyPlaceInClassObjectInObject.kt")
    public void testPropertyPlaceInClassObjectInObject() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/PropertyPlaceInClassObjectInObject.kt");
        doTest(fileName);
    }

    @TestMetadata("ReferenceInClassWhereConstraint.kt")
    public void testReferenceInClassWhereConstraint() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/ReferenceInClassWhereConstraint.kt");
        doTest(fileName);
    }

    @TestMetadata("ReferenceInFunWhereConstraint.kt")
    public void testReferenceInFunWhereConstraint() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/ReferenceInFunWhereConstraint.kt");
        doTest(fileName);
    }

    @TestMetadata("ResolveClass.kt")
    public void testResolveClass() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/ResolveClass.kt");
        doTest(fileName);
    }

    @TestMetadata("ResolvePackageInProperty.kt")
    public void testResolvePackageInProperty() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/ResolvePackageInProperty.kt");
        doTest(fileName);
    }

    @TestMetadata("SamAdapter.kt")
    public void testSamAdapter() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/SamAdapter.kt");
        doTest(fileName);
    }

    @TestMetadata("SamConstructor.kt")
    public void testSamConstructor() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/SamConstructor.kt");
        doTest(fileName);
    }

    @TestMetadata("SamConstructorTypeArguments.kt")
    public void testSamConstructorTypeArguments() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/SamConstructorTypeArguments.kt");
        doTest(fileName);
    }

    @TestMetadata("SeveralOverrides.kt")
    public void testSeveralOverrides() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/SeveralOverrides.kt");
        doTest(fileName);
    }

    @TestMetadata("TypeParameterInFunctionLiteral.kt")
    public void testTypeParameterInFunctionLiteral() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/TypeParameterInFunctionLiteral.kt");
        doTest(fileName);
    }

    @TestMetadata("WrongNumberOfTypeArguments.kt")
    public void testWrongNumberOfTypeArguments() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/WrongNumberOfTypeArguments.kt");
        doTest(fileName);
    }

    @TestMetadata("WrongNumberOfTypeArguments2.kt")
    public void testWrongNumberOfTypeArguments2() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/WrongNumberOfTypeArguments2.kt");
        doTest(fileName);
    }

    @TestMetadata("WrongNumberOfTypeArgumentsInSupertype.kt")
    public void testWrongNumberOfTypeArgumentsInSupertype() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/WrongNumberOfTypeArgumentsInSupertype.kt");
        doTest(fileName);
    }

    @TestMetadata("idea/testData/resolve/references/delegatedPropertyAccessors")
    @TestDataPath("$PROJECT_ROOT")
    @InnerTestClasses({
            DelegatedPropertyAccessors.InSource.class,
            DelegatedPropertyAccessors.InStandardLibrary.class,
    })
    @RunWith(JUnit3RunnerWithInners.class)
    public static class DelegatedPropertyAccessors extends AbstractReferenceResolveTest {
        public void testAllFilesPresentInDelegatedPropertyAccessors() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/resolve/references/delegatedPropertyAccessors"), Pattern.compile("^([^\\.]+)\\.kt$"), true);
        }

        @TestMetadata("unresolved.kt")
        public void testUnresolved() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/delegatedPropertyAccessors/unresolved.kt");
            doTest(fileName);
        }

        @TestMetadata("idea/testData/resolve/references/delegatedPropertyAccessors/inSource")
        @TestDataPath("$PROJECT_ROOT")
        @RunWith(JUnit3RunnerWithInners.class)
        public static class InSource extends AbstractReferenceResolveTest {
            public void testAllFilesPresentInInSource() throws Exception {
                JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/resolve/references/delegatedPropertyAccessors/inSource"), Pattern.compile("^([^\\.]+)\\.kt$"), true);
            }

            @TestMetadata("getExtension.kt")
            public void testGetExtension() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/delegatedPropertyAccessors/inSource/getExtension.kt");
                doTest(fileName);
            }

            @TestMetadata("getMember.kt")
            public void testGetMember() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/delegatedPropertyAccessors/inSource/getMember.kt");
                doTest(fileName);
            }

            @TestMetadata("getMultipleDeclarations.kt")
            public void testGetMultipleDeclarations() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/delegatedPropertyAccessors/inSource/getMultipleDeclarations.kt");
                doTest(fileName);
            }

            @TestMetadata("getOneFakeOverride.kt")
            public void testGetOneFakeOverride() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/delegatedPropertyAccessors/inSource/getOneFakeOverride.kt");
                doTest(fileName);
            }

            @TestMetadata("getSetPropertyDelegatedExtension.kt")
            public void testGetSetPropertyDelegatedExtension() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/delegatedPropertyAccessors/inSource/getSetPropertyDelegatedExtension.kt");
                doTest(fileName);
            }

            @TestMetadata("getSetPropertyDelegatedMember.kt")
            public void testGetSetPropertyDelegatedMember() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/delegatedPropertyAccessors/inSource/getSetPropertyDelegatedMember.kt");
                doTest(fileName);
            }
        }

        @TestMetadata("idea/testData/resolve/references/delegatedPropertyAccessors/inStandardLibrary")
        @TestDataPath("$PROJECT_ROOT")
        @RunWith(JUnit3RunnerWithInners.class)
        public static class InStandardLibrary extends AbstractReferenceResolveTest {
            public void testAllFilesPresentInInStandardLibrary() throws Exception {
                JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/resolve/references/delegatedPropertyAccessors/inStandardLibrary"), Pattern.compile("^([^\\.]+)\\.kt$"), true);
            }

            @TestMetadata("lazy.kt")
            public void testLazy() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/delegatedPropertyAccessors/inStandardLibrary/lazy.kt");
                doTest(fileName);
            }

            @TestMetadata("notNull.kt")
            public void testNotNull() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/delegatedPropertyAccessors/inStandardLibrary/notNull.kt");
                doTest(fileName);
            }
        }
    }

    @TestMetadata("idea/testData/resolve/references/forLoopIn")
    @TestDataPath("$PROJECT_ROOT")
    @InnerTestClasses({
            ForLoopIn.InBuiltIns.class,
            ForLoopIn.InLibrary.class,
            ForLoopIn.InSource.class,
    })
    @RunWith(JUnit3RunnerWithInners.class)
    public static class ForLoopIn extends AbstractReferenceResolveTest {
        public void testAllFilesPresentInForLoopIn() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/resolve/references/forLoopIn"), Pattern.compile("^([^\\.]+)\\.kt$"), true);
        }

        @TestMetadata("unresolvedIterator.kt")
        public void testUnresolvedIterator() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/forLoopIn/unresolvedIterator.kt");
            doTest(fileName);
        }

        @TestMetadata("idea/testData/resolve/references/forLoopIn/inBuiltIns")
        @TestDataPath("$PROJECT_ROOT")
        @RunWith(JUnit3RunnerWithInners.class)
        public static class InBuiltIns extends AbstractReferenceResolveTest {
            public void testAllFilesPresentInInBuiltIns() throws Exception {
                JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/resolve/references/forLoopIn/inBuiltIns"), Pattern.compile("^([^\\.]+)\\.kt$"), true);
            }

            @TestMetadata("extension.kt")
            public void testExtension() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/forLoopIn/inBuiltIns/extension.kt");
                doTest(fileName);
            }

            @TestMetadata("member.kt")
            public void testMember() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/forLoopIn/inBuiltIns/member.kt");
                doTest(fileName);
            }
        }

        @TestMetadata("idea/testData/resolve/references/forLoopIn/inLibrary")
        @TestDataPath("$PROJECT_ROOT")
        @RunWith(JUnit3RunnerWithInners.class)
        public static class InLibrary extends AbstractReferenceResolveTest {
            public void testAllFilesPresentInInLibrary() throws Exception {
                JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/resolve/references/forLoopIn/inLibrary"), Pattern.compile("^([^\\.]+)\\.kt$"), true);
            }

            @TestMetadata("extension.kt")
            public void testExtension() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/forLoopIn/inLibrary/extension.kt");
                doTest(fileName);
            }
        }

        @TestMetadata("idea/testData/resolve/references/forLoopIn/inSource")
        @TestDataPath("$PROJECT_ROOT")
        @RunWith(JUnit3RunnerWithInners.class)
        public static class InSource extends AbstractReferenceResolveTest {
            @TestMetadata("allExtensions.kt")
            public void testAllExtensions() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/forLoopIn/inSource/allExtensions.kt");
                doTest(fileName);
            }

            public void testAllFilesPresentInInSource() throws Exception {
                JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/resolve/references/forLoopIn/inSource"), Pattern.compile("^([^\\.]+)\\.kt$"), true);
            }

            @TestMetadata("allMembers.kt")
            public void testAllMembers() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/forLoopIn/inSource/allMembers.kt");
                doTest(fileName);
            }

            @TestMetadata("nextMissing.kt")
            public void testNextMissing() throws Exception {
                String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/forLoopIn/inSource/nextMissing.kt");
                doTest(fileName);
            }
        }
    }

    @TestMetadata("idea/testData/resolve/references/invoke")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Invoke extends AbstractReferenceResolveTest {
        public void testAllFilesPresentInInvoke() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/resolve/references/invoke"), Pattern.compile("^([^\\.]+)\\.kt$"), true);
        }

        @TestMetadata("lambdaAndParens.kt")
        public void testLambdaAndParens() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/invoke/lambdaAndParens.kt");
            doTest(fileName);
        }

        @TestMetadata("lambdaNoPar.kt")
        public void testLambdaNoPar() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/invoke/lambdaNoPar.kt");
            doTest(fileName);
        }

        @TestMetadata("lambdaNoParLabel.kt")
        public void testLambdaNoParLabel() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/invoke/lambdaNoParLabel.kt");
            doTest(fileName);
        }

        @TestMetadata("lambdaNoParRCurly.kt")
        public void testLambdaNoParRCurly() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/invoke/lambdaNoParRCurly.kt");
            doTest(fileName);
        }

        @TestMetadata("noParams.kt")
        public void testNoParams() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/invoke/noParams.kt");
            doTest(fileName);
        }

        @TestMetadata("noParamsRPar.kt")
        public void testNoParamsRPar() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/invoke/noParamsRPar.kt");
            doTest(fileName);
        }

        @TestMetadata("nonemptyLambdaRPar.kt")
        public void testNonemptyLambdaRPar() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/invoke/nonemptyLambdaRPar.kt");
            doTest(fileName);
        }

        @TestMetadata("oneParam.kt")
        public void testOneParam() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/invoke/oneParam.kt");
            doTest(fileName);
        }

        @TestMetadata("oneParamRPar.kt")
        public void testOneParamRPar() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/resolve/references/invoke/oneParamRPar.kt");
            doTest(fileName);
        }
    }
}
