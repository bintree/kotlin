/*
 * Copyright 2010-2017 JetBrains s.r.o.
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

package org.jetbrains.kotlin.util.slicedMap

private const val MAGIC: Int = -1268542259
private const val MAX_SHIFT = 29
private const val THRESHOLD = ((1L shl 32) * 0.5).toInt() // 50% fill factor for speed

class MyMap<K : Any, V : Any> : AbstractMutableMap<K, V>() {
    private var shift = MAX_SHIFT
    private var length = 1 shl (32 - shift)
    private var arrSize = length shl 1
    private var array = arrayOfNulls<Any>(arrSize)

    override fun get(key: K): V? {
        var i = ((key.hashCode() * MAGIC) ushr shift) shl 1
        var k = array[i]

        while (true) {
            if (k === key) return array[i + 1] as V
            if (k == null) return null
            if (key == k) return array[i + 1] as V
            if (i == 0) {
                i = arrSize
            }
            i -= 2
        }
    }

    override fun put(key: K, value: V): V? {

    }

    override fun clear() {

    }

    override val entries: MutableSet<MutableMap.MutableEntry<K, V>>
        get() = TODO("not implemented")
}
