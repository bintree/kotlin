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

package org.jetbrains.jet.codegen.context;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.asm4.Label;
import org.jetbrains.jet.codegen.OwnerKind;
import org.jetbrains.jet.codegen.StackValue;
import org.jetbrains.jet.codegen.binding.MutableClosure;
import org.jetbrains.jet.codegen.state.GenerationState;
import org.jetbrains.jet.lang.descriptors.DeclarationDescriptor;
import org.jetbrains.jet.lang.descriptors.FunctionDescriptor;
import org.jetbrains.jet.lang.descriptors.PropertyAccessorDescriptor;
import org.jetbrains.jet.lang.descriptors.SimpleFunctionDescriptor;
import org.jetbrains.jet.lang.resolve.java.AsmTypeConstants;

public class MethodContext extends CodegenContext {

    private Label methodStartLabel;

    private boolean isInlineClosure;
    
    public MethodContext(
            @NotNull FunctionDescriptor contextType,
            @NotNull OwnerKind contextKind,
            @NotNull CodegenContext parentContext
    ) {
        this(contextType, contextKind, parentContext, null);
    }

    protected MethodContext(
            @NotNull FunctionDescriptor contextType,
            @NotNull OwnerKind contextKind,
            @NotNull CodegenContext parentContext,
            @Nullable MutableClosure closure
    ) {
        super(contextType instanceof PropertyAccessorDescriptor
              ? ((PropertyAccessorDescriptor) contextType).getCorrespondingProperty()
              : contextType, contextKind, parentContext, closure,
              parentContext.hasThisDescriptor() ? parentContext.getThisDescriptor() : null, null);
    }

    @Override
    public StackValue lookupInContext(DeclarationDescriptor d, @Nullable StackValue result, GenerationState state, boolean ignoreNoOuter) {
        if (getContextDescriptor() == d) {
            return result != null ? result : StackValue.local(0, AsmTypeConstants.OBJECT_TYPE);
        }

        //noinspection ConstantConditions
        StackValue stackValue = getParentContext().lookupInContext(d, result, state, ignoreNoOuter);
        //StackValue specialStackValue = isSpecialStackValue(stackValue);
        //if (specialStackValue != null) {
        //    return specialStackValue;
        //}
        return stackValue;
    }

    @Override
    public boolean isStatic() {
        //noinspection ConstantConditions
        return getParentContext().isStatic();
    }

    @Override
    public StackValue getOuterExpression(StackValue prefix, boolean ignoreNoOuter) {
        //noinspection ConstantConditions
        return getParentContext().getOuterExpression(prefix, false);
    }

    @Nullable
    public Label getMethodStartLabel() {
        return methodStartLabel;
    }

    public void setMethodStartLabel(@NotNull Label methodStartLabel) {
        this.methodStartLabel = methodStartLabel;
    }

    @Override
    public String toString() {
        return "Method: " + getContextDescriptor();
    }

    public boolean isInlineFunction() {
        DeclarationDescriptor descriptor = getContextDescriptor();
        if (descriptor instanceof SimpleFunctionDescriptor) {
            return ((SimpleFunctionDescriptor) descriptor).isInline();
        }
        return false;
    }

    public void setInlineClosure(boolean isInlineClosure) {
        this.isInlineClosure = isInlineClosure;
    }

    public boolean isInlineClosure() {
        return isInlineClosure;
    }

    public StackValue isSpecialStackValue(StackValue stackValue) {
        if (isInlineClosure && stackValue instanceof StackValue.Composed) {
            StackValue prefix = ((StackValue.Composed) stackValue).prefix;
            StackValue suffix = ((StackValue.Composed) stackValue).suffix;
            if (prefix instanceof StackValue.Local && ((StackValue.Local) prefix).index == 0) {
                if (suffix instanceof StackValue.Field) {
                    StackValue.Field field = (StackValue.Field) suffix;
                    return StackValue.field(field.type, field.owner, field.name, true);
                }
            }
        }
        return null;
    }
}
