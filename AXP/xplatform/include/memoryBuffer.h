
#ifndef __MEMORY_BUFFER_H__
#define __MEMORY_BUFFER_H__

#include "type.h"
#include "define.h"
#include "vbuf.h"

namespace AXP {
    template <UInt32 capacity>
    class MemoryBuffer : public VBuf_<capacity>
    {
    public:

        MemoryBuffer()
        {
            mPosition = 0;
        }

        Boolean STDCALL PopFirst(PByte dst, Int64 dstLength, Int64 length)
        {
            if ((dstLength < length)
                || (VBuf_<capacity>::GetUsed() < (mPosition + length)))
                return FALSE;

            PCByte data = VBuf_<capacity>::GetPayload();
            ::memcpy((PVoid)dst, (PVoid)(data + mPosition), (Size)length);

            mPosition += length;

            return TRUE;
        }

        Boolean STDCALL PopFirst(Int64 length)
        {
            if ((length > VBuf_<capacity>::GetUsed())
                || (VBuf_<capacity>::GetUsed() < mPosition + length))
                return FALSE;

            mPosition += length;

            return TRUE;
        }

        Void STDCALL Reset()
        {
            mPosition = 0;
        }

        INLINE Boolean STDCALL IsEmpty() CONST
        {
            return (VBuf_<capacity>::GetUsed() == 0);
        }

        Int64 STDCALL GetPosition() CONST
        {
            return mPosition;
        }

        Void STDCALL SetPosition(Int64 position)
        {
            mPosition = MIN(VBuf_<capacity>::GetUsed(), position);
        }

    protected:

        Int64 mPosition;
    };
} // namespace AXP

#endif // __MEMORY_BUFFER_H__
