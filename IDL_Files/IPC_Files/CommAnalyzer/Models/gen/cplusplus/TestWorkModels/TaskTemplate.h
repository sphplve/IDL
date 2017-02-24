
#ifndef __TASKTEMPLATE_H__
#define __TASKTEMPLATE_H__

#include "AXP/cplusplus/xplatform/include/type.h"
#include "AXP/cplusplus/xplatform/include/astring.h"
#include "AXP/cplusplus/xplatform/include/list.h"
#include "AXP/cplusplus/xplatform/include/Parcel.h"
#include "AXP/cplusplus/xplatform/include/parcelable.h"
#include "Models/ObjectParcel.h"
#include "TestItem.h"

namespace TestWorkModels
{
    class CTaskTemplate : public AXP::IParcelable, public AXP::CObject
    {
    public:

        AXP::ARESULT WriteToParcel(IN CONST AXP::Sp<AXP::CParcel> & parcel)
        {
            if (parcel == NULL)
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(AXP::String::Create(L"TestWorkModels.CTaskTemplate"))))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mTaskName)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mTaskType)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mCycleCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(ObjectParcel::WriteListOfObjectToParcel(parcel, mTaskItems)))
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

            if (AXP::AFAILED(parcel->Read(mTaskName)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mTaskType)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mCycleCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(ObjectParcel::ReadListOfObjectFromParcel(parcel, mTaskItems)))
                return AXP::AE_FAIL;

            return AXP::AS_OK;
        }

        AXP::Void Copy(IN CONST AXP::Sp<CTaskTemplate> & obj)
        {
            if (obj == NULL)
                return;

            mTaskName = obj->mTaskName;
            mTaskType = obj->mTaskType;
            mCycleCount = obj->mCycleCount;
            if (obj->mTaskItems != NULL) {
                mTaskItems = new AXP::List<CTestItem>();
                if (mTaskItems == NULL)
                    return;

                Foreach (CTestItem, var, obj->mTaskItems) {
                    AXP::Sp<CTestItem> tmp = new CTestItem();
                    if (tmp == NULL)
                        return;

                    tmp->Copy(var);
                    if (!mTaskItems->PushBack(tmp))
                        return;
                }
            }
            else {
                mTaskItems = NULL;
            }
        }

        AXP::Void SetNull()
        {
            mTaskName = NULL;
            mTaskType = 0;
            mCycleCount = 0;
            mTaskItems = NULL;
        }

        VIRTUAL AXP::Sp<AXP::String> ToString()
        {
            AXP::Sp<AXP::String> json = AXP::String::Create(L"{");
            if (json == NULL)
                return NULL;

            if (mTaskName == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mTaskName\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mTaskName->Length() + 40, L"%ls\"mTaskName\":\"%ls\",", (AXP::PCWStr)*json, (AXP::PCWStr)*mTaskName);
                if (json == NULL)
                    return NULL;
            }

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mTaskType\":\"%d\",", (AXP::PCWStr)*json, mTaskType);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mCycleCount\":\"%d\",", (AXP::PCWStr)*json, mCycleCount);
            if (json == NULL)
                return NULL;

            if (mTaskItems == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mTaskItems\":[]", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                AXP::Sp<AXP::String> jsonTmp = AXP::String::Create(L"\"mTaskItems\":[");
                if (jsonTmp == NULL)
                    return NULL;

                for(AXP::Int32 i = 0; i < mTaskItems->GetCount(); ++i) {
                    AXP::Sp<CTestItem> obj = (*mTaskItems)[i];
                    AXP::PCWStr comma;
                    if (i < mTaskItems->GetCount() - 1)
                        comma = L",";
                    else
                        comma = L"";

                    if (obj == NULL)
                        return NULL;

                    AXP::Sp<AXP::String> str = obj->ToString();
                    if (str == NULL)
                        return NULL;

                    jsonTmp = AXP::String::Create(json->Length() + str->Length() + 39, L"%ls%ls%ls", (AXP::PCWStr)*json, (AXP::PCWStr)*str, comma);
                    if (jsonTmp == NULL)
                        return NULL;
                }

                jsonTmp = AXP::String::Create(jsonTmp->Length() + 7, L"%ls]", (AXP::PCWStr)*jsonTmp);
                if (jsonTmp == NULL)
                    return NULL;

                json = AXP::String::Create(json->Length() + jsonTmp->Length() + 2, L"%ls%ls", (AXP::PCWStr)*json, (AXP::PCWStr)*jsonTmp);
                if (json == NULL)
                    return NULL;
            }

            return AXP::String::Create(json->Length() + 7, L"%ls}", (AXP::PCWStr)*json);
        }

        VIRTUAL AXP::Sp<AXP::String> GetTypeName()
        {
            return AXP::String::Create(L"TestWorkModels.CTaskTemplate");
        }

    public:

        STATIC AXP::Sp<AXP::CObject> Create()
        {
            return new CTaskTemplate();
        }

    public:

        AXP::Sp<AXP::String> mTaskName;
        AXP::Int32 mTaskType;
        AXP::Int32 mCycleCount;
        AXP::Sp<AXP::List<CTestItem > > mTaskItems;
    };

    STATIC AXP::Boolean _TestWorkModels_CTaskTemplate_ = ObjectParcel::InsertMappingTable(L"TestWorkModels.CTaskTemplate", TestWorkModels::CTaskTemplate::Create);
}
#endif // __TASKTEMPLATE_H__