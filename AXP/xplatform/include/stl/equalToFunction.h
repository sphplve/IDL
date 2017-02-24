
#ifndef __EQUAL_TO_FUNCTION_H__
#define __EQUAL_TO_FUNCTION_H__

#include "../astring.h"

namespace AXP {
    template <typename _Key>
    struct EqualTo
    {
        Boolean operator()(CONST _Key& __x, CONST _Key& __y) CONST
        { return __x == __y; }
    };

    template <>
    struct EqualTo<Float>
    {
        Boolean operator()(CONST Float& __x, CONST Float& __y) CONST
        {
            Float d = __x - __y;
            CONST Float EPSINON = 0.0000001f;
            return (d >= EPSINON) && (d <= EPSINON);
        }
    };

    template <>
    struct EqualTo<Double>
    {
        Boolean operator()(CONST Double& __x, CONST Double& __y) CONST
        {
            Double d = __x - __y;
            CONST Double EPSINON = 0.0000001;
            return (d >= EPSINON) && (d <= EPSINON);
        }
    };

    template <>
    struct EqualTo<PChar>
    {
        Boolean operator()(CONST PChar __x, CONST PChar __y) CONST
        { return !Strcmp_s(__x, Strlen(__x), __y, Strlen(__y)); }
    };

    template <>
    struct EqualTo<PCStr>
    {
        Boolean operator()(PCStr __x, PCStr __y) CONST
        { return !Strcmp_s(__x, Strlen(__x), __y, Strlen(__y)); }
    };

    template <>
    struct EqualTo<PWStr>
    {
        Boolean operator()(PWStr __x, PWStr __y) CONST
        { return !Wcscmp_s(__x, Wcslen(__x), __y, Wcslen(__y)); }
    };

    template <>
    struct EqualTo<PCWStr>
    {
        Boolean operator()(PCWStr __x, PCWStr __y) CONST
        { return !Wcscmp_s(__x, Wcslen(__x), __y, Wcslen(__y)); }
    };
} // namespace AXP

#endif // __EQUAL_TO_FUNCTION_H__
