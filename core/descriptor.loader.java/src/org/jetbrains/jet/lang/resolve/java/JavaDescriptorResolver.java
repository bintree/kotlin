/*
 * Copyright 2010-2013 JetBrains s.r.o.
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

package org.jetbrains.jet.lang.resolve.java;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.jet.lang.descriptors.ClassDescriptor;
import org.jetbrains.jet.lang.descriptors.ModuleDescriptor;
import org.jetbrains.jet.lang.descriptors.PackageFragmentDescriptor;
import org.jetbrains.jet.lang.descriptors.PackageFragmentProvider;
import org.jetbrains.jet.lang.resolve.java.lazy.LazyJavaPackageFragmentProvider;
import org.jetbrains.jet.lang.resolve.name.FqName;
import org.jetbrains.jet.lang.resolve.name.Name;
import org.jetbrains.jet.lang.types.DependencyClassByQualifiedNameResolver;

public class JavaDescriptorResolver implements DependencyClassByQualifiedNameResolver {
    public static final Name JAVA_ROOT = Name.special("<java_root>");

    private final ModuleDescriptor module;

    private final LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider;

    public JavaDescriptorResolver(@NotNull LazyJavaPackageFragmentProvider provider, @NotNull ModuleDescriptor module) {
        lazyJavaPackageFragmentProvider = provider;
        this.module = module;
    }

    @NotNull
    public ModuleDescriptor getModule() {
        return module;
    }

    @NotNull
    public PackageFragmentProvider getPackageFragmentProvider() {
        return lazyJavaPackageFragmentProvider;
    }

    @Nullable
    @Override
    public ClassDescriptor resolveClass(@NotNull FqName qualifiedName) {
        return lazyJavaPackageFragmentProvider.getClass(qualifiedName);
    }

    @Nullable
    public PackageFragmentDescriptor getPackageFragment(@NotNull FqName fqName) {
        return lazyJavaPackageFragmentProvider.getPackageFragment(fqName);
    }
}
