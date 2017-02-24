
#ifndef __DELEGATE_H__
#define __DELEGATE_H__

#include "type.h"
#include "define.h"

namespace AXP {
    class Delegate
    {
    public:

        Delegate() 
        {
            mThis = NULL;
            mFunc = NULL;
        }

        Delegate(
            IN PVoid pvFunc) 
        {
            mThis = NULL;
            mFunc = pvFunc;
        }

        Delegate(
            IN PVoid pvThis,
            IN PVoid pvFunc) 
        {
            mThis = pvThis;
            mFunc = pvFunc;
        }

        Delegate & operator = (const Delegate & delegate) 
        {
            mThis = delegate.mThis;
            mFunc = delegate.mFunc;

            return *this;
        }

        Boolean operator == (const Delegate & delegate) 
        {
            return ((mThis == delegate.mThis)
                && (mFunc == delegate.mFunc));
        }

        Boolean operator != (const Delegate & delegate) 
        {
            return ((mThis != delegate.mThis)
                || (mFunc != delegate.mFunc));
        }

        PVoid GetThisPtr() 
        {
            return mThis;
        }

        PVoid GetFuncPtr() 
        {
            if (!mFunc) return NULL;
#ifndef COMPILER_GCC
            return mFunc;
#else //not gnu
#ifdef ARCH_ARM
            // for gnu-arm-pe compiler, it is another story
            // an virtual function's address &Foo::Bar() is the offset of &vptr[0]
            if ((unsigned long)mFunc & ~2047) {
                // assume interface have 512 funcs at most
                return mFunc;
            } else {
                int * vptr = *(int**)mThis;
                return *(PVoid*)((unsigned long)vptr + (unsigned long)mFunc);
            }
#elif defined(ARCH_X86)
            // In gnu c compiler, the value of pointer pointing to virtual function
            // is index * 4 + 1. The code below calculates the true address of
            // function according to pThis and pFunc.
            return (*(int*)&mFunc & 1)?
                *(*(PVoid**)mThis + (int)mFunc / 4) :
            mFunc;
#else
            ASSERT(0 && "your compiler is not support yet!\n");
            return NULL;
#endif  // ARCH_ARM
#endif // COMPILER_GCC
        }

        Boolean IsValid() 
        {
            return (NULL != mFunc);
        }

        Void Reset() 
        {
            mThis = NULL;
            mFunc = NULL;
        }

    private:

        PVoid mFunc;
        PVoid mThis;
    };
} // namespace AXP

#endif // __DELEGATE_H__
