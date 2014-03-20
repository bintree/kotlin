/*
 * Copyright 2010-2014 JetBrains s.r.o.
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

package org.jetbrains.jet.codegen.generated;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestSuite;

import java.io.File;
import java.util.regex.Pattern;
import org.jetbrains.jet.JetTestUtils;
import org.jetbrains.jet.test.InnerTestClasses;
import org.jetbrains.jet.test.TestMetadata;

import org.jetbrains.jet.codegen.generated.AbstractBlackBoxCodegenTest;

/** This class is generated by {@link org.jetbrains.jet.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("compiler/testData/codegen/boxWithJava")
@InnerTestClasses({BlackBoxWithJavaCodegenTestGenerated.Annotations.class, BlackBoxWithJavaCodegenTestGenerated.CallableReference.class, BlackBoxWithJavaCodegenTestGenerated.Constructor.class, BlackBoxWithJavaCodegenTestGenerated.Enum.class, BlackBoxWithJavaCodegenTestGenerated.Functions.class, BlackBoxWithJavaCodegenTestGenerated.InnerClass.class, BlackBoxWithJavaCodegenTestGenerated.Property.class, BlackBoxWithJavaCodegenTestGenerated.Sam.class, BlackBoxWithJavaCodegenTestGenerated.StaticFun.class, BlackBoxWithJavaCodegenTestGenerated.Visibility.class})
public class BlackBoxWithJavaCodegenTestGenerated extends AbstractBlackBoxCodegenTest {
    public void testAllFilesPresentInBoxWithJava() throws Exception {
        JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), "org.jetbrains.jet.generators.tests.TestsPackage", new File("compiler/testData/codegen/boxWithJava"), Pattern.compile("^(.+)\\.kt$"), true);
    }
    
    @TestMetadata("compiler/testData/codegen/boxWithJava/annotations")
    public static class Annotations extends AbstractBlackBoxCodegenTest {
        public void testAllFilesPresentInAnnotations() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), "org.jetbrains.jet.generators.tests.TestsPackage", new File("compiler/testData/codegen/boxWithJava/annotations"), Pattern.compile("^(.+)\\.kt$"), true);
        }
        
        @TestMetadata("javaAnnotationCall.kt")
        public void testJavaAnnotationCall() throws Exception {
            doTestWithJava("compiler/testData/codegen/boxWithJava/annotations/javaAnnotationCall.kt");
        }
        
        @TestMetadata("javaAnnotationDefault.kt")
        public void testJavaAnnotationDefault() throws Exception {
            doTestWithJava("compiler/testData/codegen/boxWithJava/annotations/javaAnnotationDefault.kt");
        }
        
        @TestMetadata("javaNegativePropertyAsAnnotationParameter.kt")
        public void testJavaNegativePropertyAsAnnotationParameter() throws Exception {
            doTestWithJava("compiler/testData/codegen/boxWithJava/annotations/javaNegativePropertyAsAnnotationParameter.kt");
        }
        
        @TestMetadata("javaPropertyAsAnnotationParameter.kt")
        public void testJavaPropertyAsAnnotationParameter() throws Exception {
            doTestWithJava("compiler/testData/codegen/boxWithJava/annotations/javaPropertyAsAnnotationParameter.kt");
        }
        
        @TestMetadata("javaPropertyWithIntInitializer.kt")
        public void testJavaPropertyWithIntInitializer() throws Exception {
            doTestWithJava("compiler/testData/codegen/boxWithJava/annotations/javaPropertyWithIntInitializer.kt");
        }
        
        @TestMetadata("RetentionInJava.kt")
        public void testRetentionInJava() throws Exception {
            doTestWithJava("compiler/testData/codegen/boxWithJava/annotations/RetentionInJava.kt");
        }
        
    }
    
    @TestMetadata("compiler/testData/codegen/boxWithJava/callableReference")
    public static class CallableReference extends AbstractBlackBoxCodegenTest {
        public void testAllFilesPresentInCallableReference() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), "org.jetbrains.jet.generators.tests.TestsPackage", new File("compiler/testData/codegen/boxWithJava/callableReference"), Pattern.compile("^(.+)\\.kt$"), true);
        }
        
        @TestMetadata("constructor.kt")
        public void testConstructor() throws Exception {
            doTestWithJava("compiler/testData/codegen/boxWithJava/callableReference/constructor.kt");
        }
        
    }
    
    @TestMetadata("compiler/testData/codegen/boxWithJava/constructor")
    public static class Constructor extends AbstractBlackBoxCodegenTest {
        public void testAllFilesPresentInConstructor() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), "org.jetbrains.jet.generators.tests.TestsPackage", new File("compiler/testData/codegen/boxWithJava/constructor"), Pattern.compile("^(.+)\\.kt$"), true);
        }
        
        @TestMetadata("genericConstructor.kt")
        public void testGenericConstructor() throws Exception {
            doTestWithJava("compiler/testData/codegen/boxWithJava/constructor/genericConstructor.kt");
        }
        
    }
    
    @TestMetadata("compiler/testData/codegen/boxWithJava/enum")
    public static class Enum extends AbstractBlackBoxCodegenTest {
        public void testAllFilesPresentInEnum() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), "org.jetbrains.jet.generators.tests.TestsPackage", new File("compiler/testData/codegen/boxWithJava/enum"), Pattern.compile("^(.+)\\.kt$"), true);
        }
        
        @TestMetadata("simpleJavaEnum.kt")
        public void testSimpleJavaEnum() throws Exception {
            doTestWithJava("compiler/testData/codegen/boxWithJava/enum/simpleJavaEnum.kt");
        }
        
        @TestMetadata("simpleJavaEnumWithFunction.kt")
        public void testSimpleJavaEnumWithFunction() throws Exception {
            doTestWithJava("compiler/testData/codegen/boxWithJava/enum/simpleJavaEnumWithFunction.kt");
        }
        
        @TestMetadata("simpleJavaEnumWithStaticImport.kt")
        public void testSimpleJavaEnumWithStaticImport() throws Exception {
            doTestWithJava("compiler/testData/codegen/boxWithJava/enum/simpleJavaEnumWithStaticImport.kt");
        }
        
        @TestMetadata("simpleJavaInnerEnum.kt")
        public void testSimpleJavaInnerEnum() throws Exception {
            doTestWithJava("compiler/testData/codegen/boxWithJava/enum/simpleJavaInnerEnum.kt");
        }
        
        @TestMetadata("staticField.kt")
        public void testStaticField() throws Exception {
            doTestWithJava("compiler/testData/codegen/boxWithJava/enum/staticField.kt");
        }
        
        @TestMetadata("staticMethod.kt")
        public void testStaticMethod() throws Exception {
            doTestWithJava("compiler/testData/codegen/boxWithJava/enum/staticMethod.kt");
        }
        
    }
    
    @TestMetadata("compiler/testData/codegen/boxWithJava/functions")
    public static class Functions extends AbstractBlackBoxCodegenTest {
        public void testAllFilesPresentInFunctions() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), "org.jetbrains.jet.generators.tests.TestsPackage", new File("compiler/testData/codegen/boxWithJava/functions"), Pattern.compile("^(.+)\\.kt$"), true);
        }
        
        @TestMetadata("constructor.kt")
        public void testConstructor() throws Exception {
            doTestWithJava("compiler/testData/codegen/boxWithJava/functions/constructor.kt");
        }
        
        @TestMetadata("max.kt")
        public void testMax() throws Exception {
            doTestWithJava("compiler/testData/codegen/boxWithJava/functions/max.kt");
        }
        
        @TestMetadata("referencesStaticInnerClassMethod.kt")
        public void testReferencesStaticInnerClassMethod() throws Exception {
            doTestWithJava("compiler/testData/codegen/boxWithJava/functions/referencesStaticInnerClassMethod.kt");
        }
        
        @TestMetadata("referencesStaticInnerClassMethodL2.kt")
        public void testReferencesStaticInnerClassMethodL2() throws Exception {
            doTestWithJava("compiler/testData/codegen/boxWithJava/functions/referencesStaticInnerClassMethodL2.kt");
        }
        
        @TestMetadata("unrelatedUpperBounds.kt")
        public void testUnrelatedUpperBounds() throws Exception {
            doTestWithJava("compiler/testData/codegen/boxWithJava/functions/unrelatedUpperBounds.kt");
        }
        
    }
    
    @TestMetadata("compiler/testData/codegen/boxWithJava/innerClass")
    public static class InnerClass extends AbstractBlackBoxCodegenTest {
        public void testAllFilesPresentInInnerClass() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), "org.jetbrains.jet.generators.tests.TestsPackage", new File("compiler/testData/codegen/boxWithJava/innerClass"), Pattern.compile("^(.+)\\.kt$"), true);
        }
        
        @TestMetadata("kt3532.kt")
        public void testKt3532() throws Exception {
            doTestWithJava("compiler/testData/codegen/boxWithJava/innerClass/kt3532.kt");
        }
        
        @TestMetadata("kt3812.kt")
        public void testKt3812() throws Exception {
            doTestWithJava("compiler/testData/codegen/boxWithJava/innerClass/kt3812.kt");
        }
        
        @TestMetadata("kt4036.kt")
        public void testKt4036() throws Exception {
            doTestWithJava("compiler/testData/codegen/boxWithJava/innerClass/kt4036.kt");
        }
        
    }
    
    @TestMetadata("compiler/testData/codegen/boxWithJava/property")
    public static class Property extends AbstractBlackBoxCodegenTest {
        public void testAllFilesPresentInProperty() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), "org.jetbrains.jet.generators.tests.TestsPackage", new File("compiler/testData/codegen/boxWithJava/property"), Pattern.compile("^(.+)\\.kt$"), true);
        }
        
        @TestMetadata("FieldAccess.kt")
        public void testFieldAccess() throws Exception {
            doTestWithJava("compiler/testData/codegen/boxWithJava/property/FieldAccess.kt");
        }
        
    }
    
    @TestMetadata("compiler/testData/codegen/boxWithJava/sam")
    @InnerTestClasses({Sam.Adapters.class})
    public static class Sam extends AbstractBlackBoxCodegenTest {
        public void testAllFilesPresentInSam() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), "org.jetbrains.jet.generators.tests.TestsPackage", new File("compiler/testData/codegen/boxWithJava/sam"), Pattern.compile("^(.+)\\.kt$"), true);
        }
        
        @TestMetadata("differentFqNames.kt")
        public void testDifferentFqNames() throws Exception {
            doTestWithJava("compiler/testData/codegen/boxWithJava/sam/differentFqNames.kt");
        }
        
        @TestMetadata("compiler/testData/codegen/boxWithJava/sam/adapters")
        @InnerTestClasses({Adapters.Operators.class})
        public static class Adapters extends AbstractBlackBoxCodegenTest {
            public void testAllFilesPresentInAdapters() throws Exception {
                JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), "org.jetbrains.jet.generators.tests.TestsPackage", new File("compiler/testData/codegen/boxWithJava/sam/adapters"), Pattern.compile("^(.+)\\.kt$"), true);
            }
            
            @TestMetadata("callAbstractAdapter.kt")
            public void testCallAbstractAdapter() throws Exception {
                doTestWithJava("compiler/testData/codegen/boxWithJava/sam/adapters/callAbstractAdapter.kt");
            }
            
            @TestMetadata("comparator.kt")
            public void testComparator() throws Exception {
                doTestWithJava("compiler/testData/codegen/boxWithJava/sam/adapters/comparator.kt");
            }
            
            @TestMetadata("constructor.kt")
            public void testConstructor() throws Exception {
                doTestWithJava("compiler/testData/codegen/boxWithJava/sam/adapters/constructor.kt");
            }
            
            @TestMetadata("fileFilter.kt")
            public void testFileFilter() throws Exception {
                doTestWithJava("compiler/testData/codegen/boxWithJava/sam/adapters/fileFilter.kt");
            }
            
            @TestMetadata("implementAdapter.kt")
            public void testImplementAdapter() throws Exception {
                doTestWithJava("compiler/testData/codegen/boxWithJava/sam/adapters/implementAdapter.kt");
            }
            
            @TestMetadata("inheritedInKotlin.kt")
            public void testInheritedInKotlin() throws Exception {
                doTestWithJava("compiler/testData/codegen/boxWithJava/sam/adapters/inheritedInKotlin.kt");
            }
            
            @TestMetadata("inheritedOverriddenAdapter.kt")
            public void testInheritedOverriddenAdapter() throws Exception {
                doTestWithJava("compiler/testData/codegen/boxWithJava/sam/adapters/inheritedOverriddenAdapter.kt");
            }
            
            @TestMetadata("inheritedSimple.kt")
            public void testInheritedSimple() throws Exception {
                doTestWithJava("compiler/testData/codegen/boxWithJava/sam/adapters/inheritedSimple.kt");
            }
            
            @TestMetadata("nonLiteralAndLiteralRunnable.kt")
            public void testNonLiteralAndLiteralRunnable() throws Exception {
                doTestWithJava("compiler/testData/codegen/boxWithJava/sam/adapters/nonLiteralAndLiteralRunnable.kt");
            }
            
            @TestMetadata("nonLiteralComparator.kt")
            public void testNonLiteralComparator() throws Exception {
                doTestWithJava("compiler/testData/codegen/boxWithJava/sam/adapters/nonLiteralComparator.kt");
            }
            
            @TestMetadata("nonLiteralInConstructor.kt")
            public void testNonLiteralInConstructor() throws Exception {
                doTestWithJava("compiler/testData/codegen/boxWithJava/sam/adapters/nonLiteralInConstructor.kt");
            }
            
            @TestMetadata("nonLiteralNull.kt")
            public void testNonLiteralNull() throws Exception {
                doTestWithJava("compiler/testData/codegen/boxWithJava/sam/adapters/nonLiteralNull.kt");
            }
            
            @TestMetadata("nonLiteralRunnable.kt")
            public void testNonLiteralRunnable() throws Exception {
                doTestWithJava("compiler/testData/codegen/boxWithJava/sam/adapters/nonLiteralRunnable.kt");
            }
            
            @TestMetadata("severalSamParameters.kt")
            public void testSeveralSamParameters() throws Exception {
                doTestWithJava("compiler/testData/codegen/boxWithJava/sam/adapters/severalSamParameters.kt");
            }
            
            @TestMetadata("simplest.kt")
            public void testSimplest() throws Exception {
                doTestWithJava("compiler/testData/codegen/boxWithJava/sam/adapters/simplest.kt");
            }
            
            @TestMetadata("superconstructor.kt")
            public void testSuperconstructor() throws Exception {
                doTestWithJava("compiler/testData/codegen/boxWithJava/sam/adapters/superconstructor.kt");
            }
            
            @TestMetadata("typeParameterOfClass.kt")
            public void testTypeParameterOfClass() throws Exception {
                doTestWithJava("compiler/testData/codegen/boxWithJava/sam/adapters/typeParameterOfClass.kt");
            }
            
            @TestMetadata("typeParameterOfMethod.kt")
            public void testTypeParameterOfMethod() throws Exception {
                doTestWithJava("compiler/testData/codegen/boxWithJava/sam/adapters/typeParameterOfMethod.kt");
            }
            
            @TestMetadata("typeParameterOfOuterClass.kt")
            public void testTypeParameterOfOuterClass() throws Exception {
                doTestWithJava("compiler/testData/codegen/boxWithJava/sam/adapters/typeParameterOfOuterClass.kt");
            }
            
            @TestMetadata("compiler/testData/codegen/boxWithJava/sam/adapters/operators")
            public static class Operators extends AbstractBlackBoxCodegenTest {
                public void testAllFilesPresentInOperators() throws Exception {
                    JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), "org.jetbrains.jet.generators.tests.TestsPackage", new File("compiler/testData/codegen/boxWithJava/sam/adapters/operators"), Pattern.compile("^(.+)\\.kt$"), true);
                }
                
                @TestMetadata("augmentedAssignmentAndSquareBrackets.kt")
                public void testAugmentedAssignmentAndSquareBrackets() throws Exception {
                    doTestWithJava("compiler/testData/codegen/boxWithJava/sam/adapters/operators/augmentedAssignmentAndSquareBrackets.kt");
                }
                
                @TestMetadata("augmentedAssignmentPure.kt")
                public void testAugmentedAssignmentPure() throws Exception {
                    doTestWithJava("compiler/testData/codegen/boxWithJava/sam/adapters/operators/augmentedAssignmentPure.kt");
                }
                
                @TestMetadata("augmentedAssignmentViaSimpleBinary.kt")
                public void testAugmentedAssignmentViaSimpleBinary() throws Exception {
                    doTestWithJava("compiler/testData/codegen/boxWithJava/sam/adapters/operators/augmentedAssignmentViaSimpleBinary.kt");
                }
                
                @TestMetadata("binary.kt")
                public void testBinary() throws Exception {
                    doTestWithJava("compiler/testData/codegen/boxWithJava/sam/adapters/operators/binary.kt");
                }
                
                @TestMetadata("compareTo.kt")
                public void testCompareTo() throws Exception {
                    doTestWithJava("compiler/testData/codegen/boxWithJava/sam/adapters/operators/compareTo.kt");
                }
                
                @TestMetadata("contains.kt")
                public void testContains() throws Exception {
                    doTestWithJava("compiler/testData/codegen/boxWithJava/sam/adapters/operators/contains.kt");
                }
                
                @TestMetadata("get.kt")
                public void testGet() throws Exception {
                    doTestWithJava("compiler/testData/codegen/boxWithJava/sam/adapters/operators/get.kt");
                }
                
                @TestMetadata("infixCall.kt")
                public void testInfixCall() throws Exception {
                    doTestWithJava("compiler/testData/codegen/boxWithJava/sam/adapters/operators/infixCall.kt");
                }
                
                @TestMetadata("invoke.kt")
                public void testInvoke() throws Exception {
                    doTestWithJava("compiler/testData/codegen/boxWithJava/sam/adapters/operators/invoke.kt");
                }
                
                @TestMetadata("multiGetSet.kt")
                public void testMultiGetSet() throws Exception {
                    doTestWithJava("compiler/testData/codegen/boxWithJava/sam/adapters/operators/multiGetSet.kt");
                }
                
                @TestMetadata("multiInvoke.kt")
                public void testMultiInvoke() throws Exception {
                    doTestWithJava("compiler/testData/codegen/boxWithJava/sam/adapters/operators/multiInvoke.kt");
                }
                
                @TestMetadata("set.kt")
                public void testSet() throws Exception {
                    doTestWithJava("compiler/testData/codegen/boxWithJava/sam/adapters/operators/set.kt");
                }
                
            }
            
            public static Test innerSuite() {
                TestSuite suite = new TestSuite("Adapters");
                suite.addTestSuite(Adapters.class);
                suite.addTestSuite(Operators.class);
                return suite;
            }
        }
        
        public static Test innerSuite() {
            TestSuite suite = new TestSuite("Sam");
            suite.addTestSuite(Sam.class);
            suite.addTest(Adapters.innerSuite());
            return suite;
        }
    }
    
    @TestMetadata("compiler/testData/codegen/boxWithJava/staticFun")
    public static class StaticFun extends AbstractBlackBoxCodegenTest {
        public void testAllFilesPresentInStaticFun() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), "org.jetbrains.jet.generators.tests.TestsPackage", new File("compiler/testData/codegen/boxWithJava/staticFun"), Pattern.compile("^(.+)\\.kt$"), true);
        }
        
        @TestMetadata("classWithNestedEnum.kt")
        public void testClassWithNestedEnum() throws Exception {
            doTestWithJava("compiler/testData/codegen/boxWithJava/staticFun/classWithNestedEnum.kt");
        }
        
    }
    
    @TestMetadata("compiler/testData/codegen/boxWithJava/visibility")
    @InnerTestClasses({Visibility.Package.class, Visibility.ProtectedAndPackage.class, Visibility.ProtectedStatic.class})
    public static class Visibility extends AbstractBlackBoxCodegenTest {
        public void testAllFilesPresentInVisibility() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), "org.jetbrains.jet.generators.tests.TestsPackage", new File("compiler/testData/codegen/boxWithJava/visibility"), Pattern.compile("^(.+)\\.kt$"), true);
        }
        
        @TestMetadata("compiler/testData/codegen/boxWithJava/visibility/package")
        public static class Package extends AbstractBlackBoxCodegenTest {
            public void testAllFilesPresentInPackage() throws Exception {
                JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), "org.jetbrains.jet.generators.tests.TestsPackage", new File("compiler/testData/codegen/boxWithJava/visibility/package"), Pattern.compile("^(.+)\\.kt$"), true);
            }
            
            @TestMetadata("kt2781.kt")
            public void testKt2781() throws Exception {
                doTestWithJava("compiler/testData/codegen/boxWithJava/visibility/package/kt2781.kt");
            }
            
            @TestMetadata("packageClass.kt")
            public void testPackageClass() throws Exception {
                doTestWithJava("compiler/testData/codegen/boxWithJava/visibility/package/packageClass.kt");
            }
            
            @TestMetadata("packageFun.kt")
            public void testPackageFun() throws Exception {
                doTestWithJava("compiler/testData/codegen/boxWithJava/visibility/package/packageFun.kt");
            }
            
            @TestMetadata("packageProperty.kt")
            public void testPackageProperty() throws Exception {
                doTestWithJava("compiler/testData/codegen/boxWithJava/visibility/package/packageProperty.kt");
            }
            
        }
        
        @TestMetadata("compiler/testData/codegen/boxWithJava/visibility/protectedAndPackage")
        public static class ProtectedAndPackage extends AbstractBlackBoxCodegenTest {
            public void testAllFilesPresentInProtectedAndPackage() throws Exception {
                JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), "org.jetbrains.jet.generators.tests.TestsPackage", new File("compiler/testData/codegen/boxWithJava/visibility/protectedAndPackage"), Pattern.compile("^(.+)\\.kt$"), true);
            }
            
            @TestMetadata("overrideProtectedFunInPackage.kt")
            public void testOverrideProtectedFunInPackage() throws Exception {
                doTestWithJava("compiler/testData/codegen/boxWithJava/visibility/protectedAndPackage/overrideProtectedFunInPackage.kt");
            }
            
            @TestMetadata("protectedFunInPackage.kt")
            public void testProtectedFunInPackage() throws Exception {
                doTestWithJava("compiler/testData/codegen/boxWithJava/visibility/protectedAndPackage/protectedFunInPackage.kt");
            }
            
            @TestMetadata("protectedPropertyInPackage.kt")
            public void testProtectedPropertyInPackage() throws Exception {
                doTestWithJava("compiler/testData/codegen/boxWithJava/visibility/protectedAndPackage/protectedPropertyInPackage.kt");
            }
            
            @TestMetadata("protectedStaticClass.kt")
            public void testProtectedStaticClass() throws Exception {
                doTestWithJava("compiler/testData/codegen/boxWithJava/visibility/protectedAndPackage/protectedStaticClass.kt");
            }
            
        }
        
        @TestMetadata("compiler/testData/codegen/boxWithJava/visibility/protectedStatic")
        public static class ProtectedStatic extends AbstractBlackBoxCodegenTest {
            public void testAllFilesPresentInProtectedStatic() throws Exception {
                JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), "org.jetbrains.jet.generators.tests.TestsPackage", new File("compiler/testData/codegen/boxWithJava/visibility/protectedStatic"), Pattern.compile("^(.+)\\.kt$"), true);
            }
            
            @TestMetadata("funCallInConstructor.kt")
            public void testFunCallInConstructor() throws Exception {
                doTestWithJava("compiler/testData/codegen/boxWithJava/visibility/protectedStatic/funCallInConstructor.kt");
            }
            
            @TestMetadata("funClassObject.kt")
            public void testFunClassObject() throws Exception {
                doTestWithJava("compiler/testData/codegen/boxWithJava/visibility/protectedStatic/funClassObject.kt");
            }
            
            @TestMetadata("funGenericClass.kt")
            public void testFunGenericClass() throws Exception {
                doTestWithJava("compiler/testData/codegen/boxWithJava/visibility/protectedStatic/funGenericClass.kt");
            }
            
            @TestMetadata("funNestedStaticClass.kt")
            public void testFunNestedStaticClass() throws Exception {
                doTestWithJava("compiler/testData/codegen/boxWithJava/visibility/protectedStatic/funNestedStaticClass.kt");
            }
            
            @TestMetadata("funNestedStaticClass2.kt")
            public void testFunNestedStaticClass2() throws Exception {
                doTestWithJava("compiler/testData/codegen/boxWithJava/visibility/protectedStatic/funNestedStaticClass2.kt");
            }
            
            @TestMetadata("funNestedStaticGenericClass.kt")
            public void testFunNestedStaticGenericClass() throws Exception {
                doTestWithJava("compiler/testData/codegen/boxWithJava/visibility/protectedStatic/funNestedStaticGenericClass.kt");
            }
            
            @TestMetadata("funNotDirectSuperClass.kt")
            public void testFunNotDirectSuperClass() throws Exception {
                doTestWithJava("compiler/testData/codegen/boxWithJava/visibility/protectedStatic/funNotDirectSuperClass.kt");
            }
            
            @TestMetadata("funObject.kt")
            public void testFunObject() throws Exception {
                doTestWithJava("compiler/testData/codegen/boxWithJava/visibility/protectedStatic/funObject.kt");
            }
            
            @TestMetadata("simpleClass.kt")
            public void testSimpleClass() throws Exception {
                doTestWithJava("compiler/testData/codegen/boxWithJava/visibility/protectedStatic/simpleClass.kt");
            }
            
            @TestMetadata("simpleClass2.kt")
            public void testSimpleClass2() throws Exception {
                doTestWithJava("compiler/testData/codegen/boxWithJava/visibility/protectedStatic/simpleClass2.kt");
            }
            
            @TestMetadata("simpleFun.kt")
            public void testSimpleFun() throws Exception {
                doTestWithJava("compiler/testData/codegen/boxWithJava/visibility/protectedStatic/simpleFun.kt");
            }
            
            @TestMetadata("simpleProperty.kt")
            public void testSimpleProperty() throws Exception {
                doTestWithJava("compiler/testData/codegen/boxWithJava/visibility/protectedStatic/simpleProperty.kt");
            }
            
        }
        
        public static Test innerSuite() {
            TestSuite suite = new TestSuite("Visibility");
            suite.addTestSuite(Visibility.class);
            suite.addTestSuite(Package.class);
            suite.addTestSuite(ProtectedAndPackage.class);
            suite.addTestSuite(ProtectedStatic.class);
            return suite;
        }
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite("BlackBoxWithJavaCodegenTestGenerated");
        suite.addTestSuite(BlackBoxWithJavaCodegenTestGenerated.class);
        suite.addTestSuite(Annotations.class);
        suite.addTestSuite(CallableReference.class);
        suite.addTestSuite(Constructor.class);
        suite.addTestSuite(Enum.class);
        suite.addTestSuite(Functions.class);
        suite.addTestSuite(InnerClass.class);
        suite.addTestSuite(Property.class);
        suite.addTest(Sam.innerSuite());
        suite.addTestSuite(StaticFun.class);
        suite.addTest(Visibility.innerSuite());
        return suite;
    }
}
