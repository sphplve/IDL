
#ifndef __CHAR_ENCODING_H__
#define __CHAR_ENCODING_H__

#include "type.h"

namespace AXP {
    enum CharEncoding {
        CharEncoding_ANSI = 0,
        CharEncoding_Unicode
    };

    template<typename T>
    struct CharEncodingCheck
    {
    };

    template<>
    struct CharEncodingCheck<Char>
    {
        STATIC Int32 GetCharEncoding()
        {
            return CharEncoding_ANSI;
        }
    };

    template<>
    struct CharEncodingCheck<WChar>
    {
        STATIC Int32 GetCharEncoding()
        {
            return CharEncoding_Unicode;
        }
    };
} // namespace AXP

#endif // __CHAR_ENCODING_H__
