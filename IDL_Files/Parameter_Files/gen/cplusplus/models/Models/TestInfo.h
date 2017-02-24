
#ifndef __TESTINFO_H__
#define __TESTINFO_H__

#include "AXP/cplusplus/xplatform/include/nullable.h"
#include "AXP/cplusplus/xplatform/include/astring.h"
#include "AXP/cplusplus/xplatform/include/Parcel.h"
#include "AXP/cplusplus/xplatform/include/parcelable.h"
#include "IPC/cplusplus/lib/include/ObjectParcel.h"

namespace Models
{
    class CTestInfo : public AXP::IParcelable, public AXP::CObject
    {
    public:

        AXP::ARESULT WriteToParcel(IN CONST AXP::Sp<AXP::CParcel> & parcel)
        {
            if (parcel == NULL)
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->WriteString(AXP::String::Create(L"Models.CTestInfo"))))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->WriteNullableInt8(mTestType)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->WriteString(mFilePath)))
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

            if (AXP::AFAILED(parcel->ReadNullableInt8(mTestType)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->ReadString(mFilePath)))
                return AXP::AE_FAIL;

            return AXP::AS_OK;
        }

        AXP::Void Copy(IN CONST AXP::Sp<CTestInfo> & obj)
        {
            if (obj == NULL)
                return;

            mTestType = obj->mTestType;
            mFilePath = obj->mFilePath;
        }

        AXP::Void SetNull()
        {
            mTestType.SetNull();
            mFilePath = NULL;
        }

        VIRTUAL AXP::Sp<AXP::String> ToString()
        {
            AXP::Sp<AXP::String> json = AXP::String::Create(L"{");
            if (json == NULL)
                return NULL;

            if (!mTestType.HasValue()) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mTestType\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + 64, L"%ls\"mTestType\":\"%d\",", (AXP::PCWStr)*json, mTestType.GetValue());
                if (json == NULL)
                    return NULL;
            }

            if (mFilePath == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mFilePath\":\"\"", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mFilePath->Length() + 40, L"%ls\"mFilePath\":\"%ls\"", (AXP::PCWStr)*json, (AXP::PCWStr)*mFilePath);
                if (json == NULL)
                    return NULL;
            }

            return AXP::String::Create(json->Length() + 7, L"%ls}", (AXP::PCWStr)*json);
        }

        VIRTUAL AXP::Sp<AXP::String> GetTypeName()
        {
            return AXP::String::Create(L"Models.CTestInfo");
        }

    public:

        STATIC AXP::Sp<AXP::CObject> Create()
        {
            return new CTestInfo();
        }

    public:

        AXP::Int8$ mTestType;
        AXP::Sp<AXP::String> mFilePath;
    };

    STATIC AXP::Boolean _Models_CTestInfo_ = ObjectParcel::InsertMappingTable(L"Models.CTestInfo", Models::CTestInfo::Create);
}
#endif // __TESTINFO_H__