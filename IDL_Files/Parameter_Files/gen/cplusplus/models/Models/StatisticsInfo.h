
#ifndef __STATISTICSINFO_H__
#define __STATISTICSINFO_H__

#include "AXP/cplusplus/xplatform/include/astring.h"
#include "AXP/cplusplus/xplatform/include/type.h"
#include "AXP/cplusplus/xplatform/include/Parcel.h"
#include "AXP/cplusplus/xplatform/include/parcelable.h"
#include "IPC/cplusplus/lib/include/ObjectParcel.h"

namespace Models
{
    class CStatisticsInfo : public AXP::IParcelable, public AXP::CObject
    {
    public:

        AXP::ARESULT WriteToParcel(IN CONST AXP::Sp<AXP::CParcel> & parcel)
        {
            if (parcel == NULL)
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->WriteString(AXP::String::Create(L"Models.CStatisticsInfo"))))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->WriteString(mName)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->WriteDouble(mValue)))
                return AXP::AE_FAIL;

            return AXP::AS_OK;
        }

        AXP::ARESULT ReadFromParcel(IN CONST AXP::Sp<AXP::CParcel> & parcel)
        {
            if (parcel == NULL)
                return AXP::AE_FAIL;

            AXP::Sp<AXP::String> className;
            if (AXP::AFAILED(parcel->ReadString(className)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->ReadString(mName)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->ReadDouble(mValue)))
                return AXP::AE_FAIL;

            return AXP::AS_OK;
        }

        AXP::Void Copy(IN CONST AXP::Sp<CStatisticsInfo> & obj)
        {
            if (obj == NULL)
                return;

            mName = obj->mName;
            mValue = obj->mValue;
        }

        AXP::Void SetNull()
        {
            mName = NULL;
            mValue = 0;
        }

        VIRTUAL AXP::Sp<AXP::String> ToString()
        {
            AXP::Sp<AXP::String> json = AXP::String::Create(L"{");
            if (json == NULL)
                return NULL;

            if (mName == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mName\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mName->Length() + 40, L"%ls\"mName\":\"%ls\",", (AXP::PCWStr)*json, (AXP::PCWStr)*mName);
                if (json == NULL)
                    return NULL;
            }

            json = AXP::String::Create(json->Length() + 315, L"%ls\"mValue\":\"%.2f\"", (AXP::PCWStr)*json, mValue);
            if (json == NULL)
                return NULL;

            return AXP::String::Create(json->Length() + 7, L"%ls}", (AXP::PCWStr)*json);
        }

        VIRTUAL AXP::Sp<AXP::String> GetTypeName()
        {
            return AXP::String::Create(L"Models.CStatisticsInfo");
        }

    public:

        STATIC AXP::Sp<AXP::CObject> Create()
        {
            return new CStatisticsInfo();
        }

    public:

        AXP::Sp<AXP::String> mName;
        AXP::Double mValue;
    };

    STATIC AXP::Boolean _Models_CStatisticsInfo_ = ObjectParcel::InsertMappingTable(L"Models.CStatisticsInfo", Models::CStatisticsInfo::Create);
}
#endif // __STATISTICSINFO_H__