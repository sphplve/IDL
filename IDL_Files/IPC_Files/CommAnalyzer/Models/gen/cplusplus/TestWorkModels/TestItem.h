
#ifndef __TESTITEM_H__
#define __TESTITEM_H__

#include "AXP/cplusplus/xplatform/include/type.h"
#include "AXP/cplusplus/xplatform/include/Parcel.h"
#include "AXP/cplusplus/xplatform/include/parcelable.h"
#include "Models/ObjectParcel.h"

namespace TestWorkModels
{
    class CTestItem : public AXP::IParcelable, public AXP::CObject
    {
    public:

        AXP::ARESULT WriteToParcel(IN CONST AXP::Sp<AXP::CParcel> & parcel)
        {
            if (parcel == NULL)
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(AXP::String::Create(L"TestWorkModels.CTestItem"))))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mItemIndex)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mIsShowButtons)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mIsDropDown)))
                return AXP::AE_FAIL;

            return AXP::AS_OK;
        }

        AXP::ARESULT ReadFromParcel(IN CONST AXP::Sp<AXP::CParcel> & parcel)
        {
            if (parcel == NULL)
                return AXP::AE_FAIL;

            AXP::Sp<AXP::String> className;
            if (AXP::AFAILED(parcel->Read(className)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mItemIndex)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mIsShowButtons)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mIsDropDown)))
                return AXP::AE_FAIL;

            return AXP::AS_OK;
        }

        AXP::Void Copy(IN CONST AXP::Sp<CTestItem> & obj)
        {
            if (obj == NULL)
                return;

            mItemIndex = obj->mItemIndex;
            mIsShowButtons = obj->mIsShowButtons;
            mIsDropDown = obj->mIsDropDown;
        }

        AXP::Void SetNull()
        {
            mItemIndex = 0;
            mIsShowButtons = 0;
            mIsDropDown = 0;
        }

        VIRTUAL AXP::Sp<AXP::String> ToString()
        {
            AXP::Sp<AXP::String> json = AXP::String::Create(L"{");
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mItemIndex\":\"%d\",", (AXP::PCWStr)*json, mItemIndex);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mIsShowButtons\":\"%ls\",", (AXP::PCWStr)*json, mIsShowButtons ? L"true" : L"false");
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mIsDropDown\":\"%ls\"", (AXP::PCWStr)*json, mIsDropDown ? L"true" : L"false");
            if (json == NULL)
                return NULL;

            return AXP::String::Create(json->Length() + 7, L"%ls}", (AXP::PCWStr)*json);
        }

        VIRTUAL AXP::Sp<AXP::String> GetTypeName()
        {
            return AXP::String::Create(L"TestWorkModels.CTestItem");
        }

    public:

        STATIC AXP::Sp<AXP::CObject> Create()
        {
            return new CTestItem();
        }

    public:

        AXP::Int32 mItemIndex;
        AXP::Boolean mIsShowButtons;
        AXP::Boolean mIsDropDown;
    };

    STATIC AXP::Boolean _TestWorkModels_CTestItem_ = ObjectParcel::InsertMappingTable(L"TestWorkModels.CTestItem", TestWorkModels::CTestItem::Create);
}
#endif // __TESTITEM_H__