
#ifndef __TESTRECORD_H__
#define __TESTRECORD_H__

#include "AXP/cplusplus/xplatform/include/type.h"
#include "AXP/cplusplus/xplatform/include/astring.h"
#include "AXP/cplusplus/xplatform/include/list.h"
#include "AXP/cplusplus/xplatform/include/Parcel.h"
#include "AXP/cplusplus/xplatform/include/parcelable.h"
#include "Models/ObjectParcel.h"

namespace TestWorkModels
{
    class CTestRecord : public AXP::IParcelable, public AXP::CObject
    {
    public:

        AXP::ARESULT WriteToParcel(IN CONST AXP::Sp<AXP::CParcel> & parcel)
        {
            if (parcel == NULL)
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(AXP::String::Create(L"TestWorkModels.CTestRecord"))))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mTime)))
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

            if (AXP::AFAILED(parcel->Read(mTime)))
                return AXP::AE_FAIL;

            return AXP::AS_OK;
        }

        AXP::Void Copy(IN CONST AXP::Sp<CTestRecord> & obj)
        {
            if (obj == NULL)
                return;

            mTime = obj->mTime;
        }

        AXP::Void SetNull()
        {
            mTime = 0;
        }

        VIRTUAL AXP::Sp<AXP::String> ToString()
        {
            return AXP::String::Create(32, L"%lld", mTime);
        }

        VIRTUAL AXP::Sp<AXP::String> GetTypeName()
        {
            return AXP::String::Create(L"TestWorkModels.CTestRecord");
        }

    public:

        STATIC AXP::Sp<AXP::CObject> Create()
        {
            return new CTestRecord();
        }

    public:

        AXP::Int64 mTime;
    };

    class CFtpHttpGroupInfo : public AXP::IParcelable, public AXP::CObject
    {
    public:

        AXP::ARESULT WriteToParcel(IN CONST AXP::Sp<AXP::CParcel> & parcel)
        {
            if (parcel == NULL)
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(AXP::String::Create(L"TestWorkModels.CFtpHttpGroupInfo"))))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mGid)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mUrl)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mFileName)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mLength)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mElapsedTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mRemainingTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mSpeedAvg)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mStatus)))
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

            if (AXP::AFAILED(parcel->Read(mGid)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mUrl)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mFileName)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mLength)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mElapsedTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mRemainingTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mSpeedAvg)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mStatus)))
                return AXP::AE_FAIL;

            return AXP::AS_OK;
        }

        AXP::Void Copy(IN CONST AXP::Sp<CFtpHttpGroupInfo> & obj)
        {
            if (obj == NULL)
                return;

            mGid = obj->mGid;
            mUrl = obj->mUrl;
            mFileName = obj->mFileName;
            mLength = obj->mLength;
            mCount = obj->mCount;
            mElapsedTime = obj->mElapsedTime;
            mRemainingTime = obj->mRemainingTime;
            mSpeedAvg = obj->mSpeedAvg;
            mStatus = obj->mStatus;
        }

        AXP::Void SetNull()
        {
            mGid = 0;
            mUrl = NULL;
            mFileName = NULL;
            mLength = 0;
            mCount = 0;
            mElapsedTime = 0;
            mRemainingTime = 0;
            mSpeedAvg = 0;
            mStatus = 0;
        }

        VIRTUAL AXP::Sp<AXP::String> ToString()
        {
            AXP::Sp<AXP::String> json = AXP::String::Create(L"{");
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mGid\":\"%d\",", (AXP::PCWStr)*json, mGid);
            if (json == NULL)
                return NULL;

            if (mUrl == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mUrl\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mUrl->Length() + 40, L"%ls\"mUrl\":\"%ls\",", (AXP::PCWStr)*json, (AXP::PCWStr)*mUrl);
                if (json == NULL)
                    return NULL;
            }

            if (mFileName == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mFileName\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mFileName->Length() + 40, L"%ls\"mFileName\":\"%ls\",", (AXP::PCWStr)*json, (AXP::PCWStr)*mFileName);
                if (json == NULL)
                    return NULL;
            }

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mLength\":\"%lld\",", (AXP::PCWStr)*json, mLength);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mCount\":\"%lld\",", (AXP::PCWStr)*json, mCount);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mElapsedTime\":\"%lld\",", (AXP::PCWStr)*json, mElapsedTime);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mRemainingTime\":\"%lld\",", (AXP::PCWStr)*json, mRemainingTime);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 315, L"%ls\"mSpeedAvg\":\"%.2f\",", (AXP::PCWStr)*json, mSpeedAvg);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mStatus\":\"%d\"", (AXP::PCWStr)*json, mStatus);
            if (json == NULL)
                return NULL;

            return AXP::String::Create(json->Length() + 7, L"%ls}", (AXP::PCWStr)*json);
        }

        VIRTUAL AXP::Sp<AXP::String> GetTypeName()
        {
            return AXP::String::Create(L"TestWorkModels.CFtpHttpGroupInfo");
        }

    public:

        STATIC AXP::Sp<AXP::CObject> Create()
        {
            return new CFtpHttpGroupInfo();
        }

    public:

        AXP::Int32 mGid;
        AXP::Sp<AXP::String> mUrl;
        AXP::Sp<AXP::String> mFileName;
        AXP::Int64 mLength;
        AXP::Int64 mCount;
        AXP::Int64 mElapsedTime;
        AXP::Int64 mRemainingTime;
        AXP::Double mSpeedAvg;
        AXP::Int32 mStatus;
    };

    class CFtpTestRecord : public CTestRecord
    {
    public:

        AXP::ARESULT WriteToParcel(IN CONST AXP::Sp<AXP::CParcel> & parcel)
        {
            if (parcel == NULL)
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(AXP::String::Create(L"TestWorkModels.CFtpTestRecord"))))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(CTestRecord::WriteToParcel(parcel)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mSpeedAvg)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mUsers)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(ObjectParcel::WriteListOfObjectToParcel(parcel, mGroupInfos)))
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

            if (AXP::AFAILED(CTestRecord::ReadFromParcel(parcel)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mSpeedAvg)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mUsers)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(ObjectParcel::ReadListOfObjectFromParcel(parcel, mGroupInfos)))
                return AXP::AE_FAIL;

            return AXP::AS_OK;
        }

        AXP::Void Copy(IN CONST AXP::Sp<CFtpTestRecord> & obj)
        {
            if (obj == NULL)
                return;

            CTestRecord::Copy(obj);

            mSpeedAvg = obj->mSpeedAvg;
            mUsers = obj->mUsers;
            if (obj->mGroupInfos != NULL) {
                mGroupInfos = new AXP::List<CFtpHttpGroupInfo>();
                if (mGroupInfos == NULL)
                    return;

                Foreach (CFtpHttpGroupInfo, var, obj->mGroupInfos) {
                    AXP::Sp<CFtpHttpGroupInfo> tmp = new CFtpHttpGroupInfo();
                    if (tmp == NULL)
                        return;

                    tmp->Copy(var);
                    if (!mGroupInfos->PushBack(tmp))
                        return;
                }
            }
            else {
                mGroupInfos = NULL;
            }
        }

        AXP::Void SetNull()
        {
            CTestRecord::SetNull();

            mSpeedAvg = 0;
            mUsers = 0;
            mGroupInfos = NULL;
        }

        VIRTUAL AXP::Sp<AXP::String> ToString()
        {
            AXP::Sp<AXP::String> json = AXP::String::Create(L"{");
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 315, L"%ls\"mSpeedAvg\":\"%.2f\",", (AXP::PCWStr)*json, mSpeedAvg);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mUsers\":\"%d\",", (AXP::PCWStr)*json, mUsers);
            if (json == NULL)
                return NULL;

            if (mGroupInfos == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mGroupInfos\":[]", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                AXP::Sp<AXP::String> jsonTmp = AXP::String::Create(L"\"mGroupInfos\":[");
                if (jsonTmp == NULL)
                    return NULL;

                for(AXP::Int32 i = 0; i < mGroupInfos->GetCount(); ++i) {
                    AXP::Sp<CFtpHttpGroupInfo> obj = (*mGroupInfos)[i];
                    AXP::PCWStr comma;
                    if (i < mGroupInfos->GetCount() - 1)
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
            return AXP::String::Create(L"TestWorkModels.CFtpTestRecord");
        }

    public:

        STATIC AXP::Sp<AXP::CObject> Create()
        {
            return new CFtpTestRecord();
        }

    public:

        AXP::Double mSpeedAvg;
        AXP::Int32 mUsers;
        AXP::Sp<AXP::List<CFtpHttpGroupInfo > > mGroupInfos;
    };

    class CHttpTestRecord : public CTestRecord
    {
    public:

        AXP::ARESULT WriteToParcel(IN CONST AXP::Sp<AXP::CParcel> & parcel)
        {
            if (parcel == NULL)
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(AXP::String::Create(L"TestWorkModels.CHttpTestRecord"))))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(CTestRecord::WriteToParcel(parcel)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mSpeedAvg)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(ObjectParcel::WriteListOfObjectToParcel(parcel, mGroupInfos)))
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

            if (AXP::AFAILED(CTestRecord::ReadFromParcel(parcel)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mSpeedAvg)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(ObjectParcel::ReadListOfObjectFromParcel(parcel, mGroupInfos)))
                return AXP::AE_FAIL;

            return AXP::AS_OK;
        }

        AXP::Void Copy(IN CONST AXP::Sp<CHttpTestRecord> & obj)
        {
            if (obj == NULL)
                return;

            CTestRecord::Copy(obj);

            mSpeedAvg = obj->mSpeedAvg;
            if (obj->mGroupInfos != NULL) {
                mGroupInfos = new AXP::List<CFtpHttpGroupInfo>();
                if (mGroupInfos == NULL)
                    return;

                Foreach (CFtpHttpGroupInfo, var, obj->mGroupInfos) {
                    AXP::Sp<CFtpHttpGroupInfo> tmp = new CFtpHttpGroupInfo();
                    if (tmp == NULL)
                        return;

                    tmp->Copy(var);
                    if (!mGroupInfos->PushBack(tmp))
                        return;
                }
            }
            else {
                mGroupInfos = NULL;
            }
        }

        AXP::Void SetNull()
        {
            CTestRecord::SetNull();

            mSpeedAvg = 0;
            mGroupInfos = NULL;
        }

        VIRTUAL AXP::Sp<AXP::String> ToString()
        {
            AXP::Sp<AXP::String> json = AXP::String::Create(L"{");
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 315, L"%ls\"mSpeedAvg\":\"%.2f\",", (AXP::PCWStr)*json, mSpeedAvg);
            if (json == NULL)
                return NULL;

            if (mGroupInfos == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mGroupInfos\":[]", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                AXP::Sp<AXP::String> jsonTmp = AXP::String::Create(L"\"mGroupInfos\":[");
                if (jsonTmp == NULL)
                    return NULL;

                for(AXP::Int32 i = 0; i < mGroupInfos->GetCount(); ++i) {
                    AXP::Sp<CFtpHttpGroupInfo> obj = (*mGroupInfos)[i];
                    AXP::PCWStr comma;
                    if (i < mGroupInfos->GetCount() - 1)
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
            return AXP::String::Create(L"TestWorkModels.CHttpTestRecord");
        }

    public:

        STATIC AXP::Sp<AXP::CObject> Create()
        {
            return new CHttpTestRecord();
        }

    public:

        AXP::Double mSpeedAvg;
        AXP::Sp<AXP::List<CFtpHttpGroupInfo > > mGroupInfos;
    };

    class CMailTestRecord : public CTestRecord
    {
    public:

        AXP::ARESULT WriteToParcel(IN CONST AXP::Sp<AXP::CParcel> & parcel)
        {
            if (parcel == NULL)
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(AXP::String::Create(L"TestWorkModels.CMailTestRecord"))))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(CTestRecord::WriteToParcel(parcel)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mIndex)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mMailAddress)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mIsSuccess)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mElapsed)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mSuccessCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mFailCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mCount)))
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

            if (AXP::AFAILED(CTestRecord::ReadFromParcel(parcel)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mIndex)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mMailAddress)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mIsSuccess)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mElapsed)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mSuccessCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mFailCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mCount)))
                return AXP::AE_FAIL;

            return AXP::AS_OK;
        }

        AXP::Void Copy(IN CONST AXP::Sp<CMailTestRecord> & obj)
        {
            if (obj == NULL)
                return;

            CTestRecord::Copy(obj);

            mIndex = obj->mIndex;
            mMailAddress = obj->mMailAddress;
            mIsSuccess = obj->mIsSuccess;
            mElapsed = obj->mElapsed;
            mSuccessCount = obj->mSuccessCount;
            mFailCount = obj->mFailCount;
            mCount = obj->mCount;
        }

        AXP::Void SetNull()
        {
            CTestRecord::SetNull();

            mIndex = 0;
            mMailAddress = NULL;
            mIsSuccess = 0;
            mElapsed = 0;
            mSuccessCount = 0;
            mFailCount = 0;
            mCount = 0;
        }

        VIRTUAL AXP::Sp<AXP::String> ToString()
        {
            AXP::Sp<AXP::String> json = AXP::String::Create(L"{");
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mIndex\":\"%d\",", (AXP::PCWStr)*json, mIndex);
            if (json == NULL)
                return NULL;

            if (mMailAddress == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mMailAddress\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mMailAddress->Length() + 40, L"%ls\"mMailAddress\":\"%ls\",", (AXP::PCWStr)*json, (AXP::PCWStr)*mMailAddress);
                if (json == NULL)
                    return NULL;
            }

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mIsSuccess\":\"%ls\",", (AXP::PCWStr)*json, mIsSuccess ? L"true" : L"false");
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mElapsed\":\"%lld\",", (AXP::PCWStr)*json, mElapsed);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mSuccessCount\":\"%d\",", (AXP::PCWStr)*json, mSuccessCount);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mFailCount\":\"%d\",", (AXP::PCWStr)*json, mFailCount);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mCount\":\"%d\"", (AXP::PCWStr)*json, mCount);
            if (json == NULL)
                return NULL;

            return AXP::String::Create(json->Length() + 7, L"%ls}", (AXP::PCWStr)*json);
        }

        VIRTUAL AXP::Sp<AXP::String> GetTypeName()
        {
            return AXP::String::Create(L"TestWorkModels.CMailTestRecord");
        }

    public:

        STATIC AXP::Sp<AXP::CObject> Create()
        {
            return new CMailTestRecord();
        }

    public:

        AXP::Int32 mIndex;
        AXP::Sp<AXP::String> mMailAddress;
        AXP::Boolean mIsSuccess;
        AXP::Int64 mElapsed;
        AXP::Int32 mSuccessCount;
        AXP::Int32 mFailCount;
        AXP::Int32 mCount;
    };

    class CPingTestRecord : public CTestRecord
    {
    public:

        AXP::ARESULT WriteToParcel(IN CONST AXP::Sp<AXP::CParcel> & parcel)
        {
            if (parcel == NULL)
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(AXP::String::Create(L"TestWorkModels.CPingTestRecord"))))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(CTestRecord::WriteToParcel(parcel)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mIndex)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mPacketSize)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mTtl)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mDelay)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mSuccessCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mFailCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mAddress)))
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

            if (AXP::AFAILED(CTestRecord::ReadFromParcel(parcel)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mIndex)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mPacketSize)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mTtl)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mDelay)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mSuccessCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mFailCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mAddress)))
                return AXP::AE_FAIL;

            return AXP::AS_OK;
        }

        AXP::Void Copy(IN CONST AXP::Sp<CPingTestRecord> & obj)
        {
            if (obj == NULL)
                return;

            CTestRecord::Copy(obj);

            mIndex = obj->mIndex;
            mPacketSize = obj->mPacketSize;
            mTtl = obj->mTtl;
            mDelay = obj->mDelay;
            mSuccessCount = obj->mSuccessCount;
            mFailCount = obj->mFailCount;
            mCount = obj->mCount;
            mAddress = obj->mAddress;
        }

        AXP::Void SetNull()
        {
            CTestRecord::SetNull();

            mIndex = 0;
            mPacketSize = 0;
            mTtl = 0;
            mDelay = 0;
            mSuccessCount = 0;
            mFailCount = 0;
            mCount = 0;
            mAddress = NULL;
        }

        VIRTUAL AXP::Sp<AXP::String> ToString()
        {
            AXP::Sp<AXP::String> json = AXP::String::Create(L"{");
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mIndex\":\"%d\",", (AXP::PCWStr)*json, mIndex);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mPacketSize\":\"%d\",", (AXP::PCWStr)*json, mPacketSize);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mTtl\":\"%d\",", (AXP::PCWStr)*json, mTtl);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mDelay\":\"%lld\",", (AXP::PCWStr)*json, mDelay);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mSuccessCount\":\"%d\",", (AXP::PCWStr)*json, mSuccessCount);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mFailCount\":\"%d\",", (AXP::PCWStr)*json, mFailCount);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mCount\":\"%d\",", (AXP::PCWStr)*json, mCount);
            if (json == NULL)
                return NULL;

            if (mAddress == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mAddress\":\"\"", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mAddress->Length() + 40, L"%ls\"mAddress\":\"%ls\"", (AXP::PCWStr)*json, (AXP::PCWStr)*mAddress);
                if (json == NULL)
                    return NULL;
            }

            return AXP::String::Create(json->Length() + 7, L"%ls}", (AXP::PCWStr)*json);
        }

        VIRTUAL AXP::Sp<AXP::String> GetTypeName()
        {
            return AXP::String::Create(L"TestWorkModels.CPingTestRecord");
        }

    public:

        STATIC AXP::Sp<AXP::CObject> Create()
        {
            return new CPingTestRecord();
        }

    public:

        AXP::Int32 mIndex;
        AXP::Int32 mPacketSize;
        AXP::Int32 mTtl;
        AXP::Int64 mDelay;
        AXP::Int32 mSuccessCount;
        AXP::Int32 mFailCount;
        AXP::Int32 mCount;
        AXP::Sp<AXP::String> mAddress;
    };

    class CTraceRouteTestRecord : public CTestRecord
    {
    public:

        AXP::ARESULT WriteToParcel(IN CONST AXP::Sp<AXP::CParcel> & parcel)
        {
            if (parcel == NULL)
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(AXP::String::Create(L"TestWorkModels.CTraceRouteTestRecord"))))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(CTestRecord::WriteToParcel(parcel)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mGid)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mIndex)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mPacketSize)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mAddress)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mTtl)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mDelay)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mStatisticsTtl)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mStatisticsDelay)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mSuccessCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mFailCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mCount)))
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

            if (AXP::AFAILED(CTestRecord::ReadFromParcel(parcel)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mGid)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mIndex)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mPacketSize)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mAddress)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mTtl)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mDelay)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mStatisticsTtl)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mStatisticsDelay)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mSuccessCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mFailCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mCount)))
                return AXP::AE_FAIL;

            return AXP::AS_OK;
        }

        AXP::Void Copy(IN CONST AXP::Sp<CTraceRouteTestRecord> & obj)
        {
            if (obj == NULL)
                return;

            CTestRecord::Copy(obj);

            mGid = obj->mGid;
            mIndex = obj->mIndex;
            mPacketSize = obj->mPacketSize;
            mAddress = obj->mAddress;
            mTtl = obj->mTtl;
            mDelay = obj->mDelay;
            mStatisticsTtl = obj->mStatisticsTtl;
            mStatisticsDelay = obj->mStatisticsDelay;
            mSuccessCount = obj->mSuccessCount;
            mFailCount = obj->mFailCount;
            mCount = obj->mCount;
        }

        AXP::Void SetNull()
        {
            CTestRecord::SetNull();

            mGid = 0;
            mIndex = 0;
            mPacketSize = 0;
            mAddress = NULL;
            mTtl = 0;
            mDelay = 0;
            mStatisticsTtl = 0;
            mStatisticsDelay = 0;
            mSuccessCount = 0;
            mFailCount = 0;
            mCount = 0;
        }

        VIRTUAL AXP::Sp<AXP::String> ToString()
        {
            AXP::Sp<AXP::String> json = AXP::String::Create(L"{");
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mGid\":\"%d\",", (AXP::PCWStr)*json, mGid);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mIndex\":\"%d\",", (AXP::PCWStr)*json, mIndex);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mPacketSize\":\"%d\",", (AXP::PCWStr)*json, mPacketSize);
            if (json == NULL)
                return NULL;

            if (mAddress == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mAddress\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mAddress->Length() + 40, L"%ls\"mAddress\":\"%ls\",", (AXP::PCWStr)*json, (AXP::PCWStr)*mAddress);
                if (json == NULL)
                    return NULL;
            }

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mTtl\":\"%d\",", (AXP::PCWStr)*json, mTtl);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mDelay\":\"%lld\",", (AXP::PCWStr)*json, mDelay);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mStatisticsTtl\":\"%d\",", (AXP::PCWStr)*json, mStatisticsTtl);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mStatisticsDelay\":\"%lld\",", (AXP::PCWStr)*json, mStatisticsDelay);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mSuccessCount\":\"%d\",", (AXP::PCWStr)*json, mSuccessCount);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mFailCount\":\"%d\",", (AXP::PCWStr)*json, mFailCount);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mCount\":\"%d\"", (AXP::PCWStr)*json, mCount);
            if (json == NULL)
                return NULL;

            return AXP::String::Create(json->Length() + 7, L"%ls}", (AXP::PCWStr)*json);
        }

        VIRTUAL AXP::Sp<AXP::String> GetTypeName()
        {
            return AXP::String::Create(L"TestWorkModels.CTraceRouteTestRecord");
        }

    public:

        STATIC AXP::Sp<AXP::CObject> Create()
        {
            return new CTraceRouteTestRecord();
        }

    public:

        AXP::Int32 mGid;
        AXP::Int32 mIndex;
        AXP::Int32 mPacketSize;
        AXP::Sp<AXP::String> mAddress;
        AXP::Int32 mTtl;
        AXP::Int64 mDelay;
        AXP::Int32 mStatisticsTtl;
        AXP::Int64 mStatisticsDelay;
        AXP::Int32 mSuccessCount;
        AXP::Int32 mFailCount;
        AXP::Int32 mCount;
    };

    class CVideoStreamTestRecord : public CTestRecord
    {
    public:

        AXP::ARESULT WriteToParcel(IN CONST AXP::Sp<AXP::CParcel> & parcel)
        {
            if (parcel == NULL)
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(AXP::String::Create(L"TestWorkModels.CVideoStreamTestRecord"))))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(CTestRecord::WriteToParcel(parcel)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mIndex)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mUrl)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mIsSuccess)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mElapsed)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mSuccessCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mFailCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mCount)))
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

            if (AXP::AFAILED(CTestRecord::ReadFromParcel(parcel)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mIndex)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mUrl)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mIsSuccess)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mElapsed)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mSuccessCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mFailCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mCount)))
                return AXP::AE_FAIL;

            return AXP::AS_OK;
        }

        AXP::Void Copy(IN CONST AXP::Sp<CVideoStreamTestRecord> & obj)
        {
            if (obj == NULL)
                return;

            CTestRecord::Copy(obj);

            mIndex = obj->mIndex;
            mUrl = obj->mUrl;
            mIsSuccess = obj->mIsSuccess;
            mElapsed = obj->mElapsed;
            mSuccessCount = obj->mSuccessCount;
            mFailCount = obj->mFailCount;
            mCount = obj->mCount;
        }

        AXP::Void SetNull()
        {
            CTestRecord::SetNull();

            mIndex = 0;
            mUrl = NULL;
            mIsSuccess = 0;
            mElapsed = 0;
            mSuccessCount = 0;
            mFailCount = 0;
            mCount = 0;
        }

        VIRTUAL AXP::Sp<AXP::String> ToString()
        {
            AXP::Sp<AXP::String> json = AXP::String::Create(L"{");
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mIndex\":\"%d\",", (AXP::PCWStr)*json, mIndex);
            if (json == NULL)
                return NULL;

            if (mUrl == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mUrl\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mUrl->Length() + 40, L"%ls\"mUrl\":\"%ls\",", (AXP::PCWStr)*json, (AXP::PCWStr)*mUrl);
                if (json == NULL)
                    return NULL;
            }

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mIsSuccess\":\"%ls\",", (AXP::PCWStr)*json, mIsSuccess ? L"true" : L"false");
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mElapsed\":\"%lld\",", (AXP::PCWStr)*json, mElapsed);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mSuccessCount\":\"%d\",", (AXP::PCWStr)*json, mSuccessCount);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mFailCount\":\"%d\",", (AXP::PCWStr)*json, mFailCount);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mCount\":\"%d\"", (AXP::PCWStr)*json, mCount);
            if (json == NULL)
                return NULL;

            return AXP::String::Create(json->Length() + 7, L"%ls}", (AXP::PCWStr)*json);
        }

        VIRTUAL AXP::Sp<AXP::String> GetTypeName()
        {
            return AXP::String::Create(L"TestWorkModels.CVideoStreamTestRecord");
        }

    public:

        STATIC AXP::Sp<AXP::CObject> Create()
        {
            return new CVideoStreamTestRecord();
        }

    public:

        AXP::Int32 mIndex;
        AXP::Sp<AXP::String> mUrl;
        AXP::Boolean mIsSuccess;
        AXP::Int64 mElapsed;
        AXP::Int32 mSuccessCount;
        AXP::Int32 mFailCount;
        AXP::Int32 mCount;
    };

    class CHttpPageTestRecord : public CTestRecord
    {
    public:

        AXP::ARESULT WriteToParcel(IN CONST AXP::Sp<AXP::CParcel> & parcel)
        {
            if (parcel == NULL)
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(AXP::String::Create(L"TestWorkModels.CHttpPageTestRecord"))))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(CTestRecord::WriteToParcel(parcel)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mIndex)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mLogonElapsed)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mLogonSuccessCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mLogonFailCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mLogonCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mRefreshElapsed)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mRefreshSuccessCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mRefreshFailCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mRefreshCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mLogonSuccess)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mRefreshSuccess)))
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

            if (AXP::AFAILED(CTestRecord::ReadFromParcel(parcel)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mIndex)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mLogonElapsed)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mLogonSuccessCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mLogonFailCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mLogonCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mRefreshElapsed)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mRefreshSuccessCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mRefreshFailCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mRefreshCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mLogonSuccess)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mRefreshSuccess)))
                return AXP::AE_FAIL;

            return AXP::AS_OK;
        }

        AXP::Void Copy(IN CONST AXP::Sp<CHttpPageTestRecord> & obj)
        {
            if (obj == NULL)
                return;

            CTestRecord::Copy(obj);

            mIndex = obj->mIndex;
            mLogonElapsed = obj->mLogonElapsed;
            mLogonSuccessCount = obj->mLogonSuccessCount;
            mLogonFailCount = obj->mLogonFailCount;
            mLogonCount = obj->mLogonCount;
            mRefreshElapsed = obj->mRefreshElapsed;
            mRefreshSuccessCount = obj->mRefreshSuccessCount;
            mRefreshFailCount = obj->mRefreshFailCount;
            mRefreshCount = obj->mRefreshCount;
            mLogonSuccess = obj->mLogonSuccess;
            mRefreshSuccess = obj->mRefreshSuccess;
        }

        AXP::Void SetNull()
        {
            CTestRecord::SetNull();

            mIndex = 0;
            mLogonElapsed = 0;
            mLogonSuccessCount = 0;
            mLogonFailCount = 0;
            mLogonCount = 0;
            mRefreshElapsed = 0;
            mRefreshSuccessCount = 0;
            mRefreshFailCount = 0;
            mRefreshCount = 0;
            mLogonSuccess = 0;
            mRefreshSuccess = 0;
        }

        VIRTUAL AXP::Sp<AXP::String> ToString()
        {
            AXP::Sp<AXP::String> json = AXP::String::Create(L"{");
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mIndex\":\"%d\",", (AXP::PCWStr)*json, mIndex);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mLogonElapsed\":\"%lld\",", (AXP::PCWStr)*json, mLogonElapsed);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mLogonSuccessCount\":\"%d\",", (AXP::PCWStr)*json, mLogonSuccessCount);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mLogonFailCount\":\"%d\",", (AXP::PCWStr)*json, mLogonFailCount);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mLogonCount\":\"%d\",", (AXP::PCWStr)*json, mLogonCount);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mRefreshElapsed\":\"%lld\",", (AXP::PCWStr)*json, mRefreshElapsed);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mRefreshSuccessCount\":\"%d\",", (AXP::PCWStr)*json, mRefreshSuccessCount);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mRefreshFailCount\":\"%d\",", (AXP::PCWStr)*json, mRefreshFailCount);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mRefreshCount\":\"%d\",", (AXP::PCWStr)*json, mRefreshCount);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mLogonSuccess\":\"%ls\",", (AXP::PCWStr)*json, mLogonSuccess ? L"true" : L"false");
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mRefreshSuccess\":\"%ls\"", (AXP::PCWStr)*json, mRefreshSuccess ? L"true" : L"false");
            if (json == NULL)
                return NULL;

            return AXP::String::Create(json->Length() + 7, L"%ls}", (AXP::PCWStr)*json);
        }

        VIRTUAL AXP::Sp<AXP::String> GetTypeName()
        {
            return AXP::String::Create(L"TestWorkModels.CHttpPageTestRecord");
        }

    public:

        STATIC AXP::Sp<AXP::CObject> Create()
        {
            return new CHttpPageTestRecord();
        }

    public:

        AXP::Int32 mIndex;
        AXP::Int64 mLogonElapsed;
        AXP::Int32 mLogonSuccessCount;
        AXP::Int32 mLogonFailCount;
        AXP::Int32 mLogonCount;
        AXP::Int64 mRefreshElapsed;
        AXP::Int32 mRefreshSuccessCount;
        AXP::Int32 mRefreshFailCount;
        AXP::Int32 mRefreshCount;
        AXP::Boolean mLogonSuccess;
        AXP::Boolean mRefreshSuccess;
    };

    class CWapPageTestRecord : public CTestRecord
    {
    public:

        AXP::ARESULT WriteToParcel(IN CONST AXP::Sp<AXP::CParcel> & parcel)
        {
            if (parcel == NULL)
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(AXP::String::Create(L"TestWorkModels.CWapPageTestRecord"))))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(CTestRecord::WriteToParcel(parcel)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mIndex)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mLogonElapsed)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mLogonSuccessCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mLogonFailCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mLogonCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mRefreshElapsed)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mRefreshSuccessCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mRefreshFailCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mRefreshCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mLogonSuccess)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mRefreshSuccess)))
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

            if (AXP::AFAILED(CTestRecord::ReadFromParcel(parcel)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mIndex)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mLogonElapsed)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mLogonSuccessCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mLogonFailCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mLogonCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mRefreshElapsed)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mRefreshSuccessCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mRefreshFailCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mRefreshCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mLogonSuccess)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mRefreshSuccess)))
                return AXP::AE_FAIL;

            return AXP::AS_OK;
        }

        AXP::Void Copy(IN CONST AXP::Sp<CWapPageTestRecord> & obj)
        {
            if (obj == NULL)
                return;

            CTestRecord::Copy(obj);

            mIndex = obj->mIndex;
            mLogonElapsed = obj->mLogonElapsed;
            mLogonSuccessCount = obj->mLogonSuccessCount;
            mLogonFailCount = obj->mLogonFailCount;
            mLogonCount = obj->mLogonCount;
            mRefreshElapsed = obj->mRefreshElapsed;
            mRefreshSuccessCount = obj->mRefreshSuccessCount;
            mRefreshFailCount = obj->mRefreshFailCount;
            mRefreshCount = obj->mRefreshCount;
            mLogonSuccess = obj->mLogonSuccess;
            mRefreshSuccess = obj->mRefreshSuccess;
        }

        AXP::Void SetNull()
        {
            CTestRecord::SetNull();

            mIndex = 0;
            mLogonElapsed = 0;
            mLogonSuccessCount = 0;
            mLogonFailCount = 0;
            mLogonCount = 0;
            mRefreshElapsed = 0;
            mRefreshSuccessCount = 0;
            mRefreshFailCount = 0;
            mRefreshCount = 0;
            mLogonSuccess = 0;
            mRefreshSuccess = 0;
        }

        VIRTUAL AXP::Sp<AXP::String> ToString()
        {
            AXP::Sp<AXP::String> json = AXP::String::Create(L"{");
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mIndex\":\"%d\",", (AXP::PCWStr)*json, mIndex);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mLogonElapsed\":\"%lld\",", (AXP::PCWStr)*json, mLogonElapsed);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mLogonSuccessCount\":\"%d\",", (AXP::PCWStr)*json, mLogonSuccessCount);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mLogonFailCount\":\"%d\",", (AXP::PCWStr)*json, mLogonFailCount);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mLogonCount\":\"%d\",", (AXP::PCWStr)*json, mLogonCount);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mRefreshElapsed\":\"%lld\",", (AXP::PCWStr)*json, mRefreshElapsed);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mRefreshSuccessCount\":\"%d\",", (AXP::PCWStr)*json, mRefreshSuccessCount);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mRefreshFailCount\":\"%d\",", (AXP::PCWStr)*json, mRefreshFailCount);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mRefreshCount\":\"%d\",", (AXP::PCWStr)*json, mRefreshCount);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mLogonSuccess\":\"%ls\",", (AXP::PCWStr)*json, mLogonSuccess ? L"true" : L"false");
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mRefreshSuccess\":\"%ls\"", (AXP::PCWStr)*json, mRefreshSuccess ? L"true" : L"false");
            if (json == NULL)
                return NULL;

            return AXP::String::Create(json->Length() + 7, L"%ls}", (AXP::PCWStr)*json);
        }

        VIRTUAL AXP::Sp<AXP::String> GetTypeName()
        {
            return AXP::String::Create(L"TestWorkModels.CWapPageTestRecord");
        }

    public:

        STATIC AXP::Sp<AXP::CObject> Create()
        {
            return new CWapPageTestRecord();
        }

    public:

        AXP::Int32 mIndex;
        AXP::Int64 mLogonElapsed;
        AXP::Int32 mLogonSuccessCount;
        AXP::Int32 mLogonFailCount;
        AXP::Int32 mLogonCount;
        AXP::Int64 mRefreshElapsed;
        AXP::Int32 mRefreshSuccessCount;
        AXP::Int32 mRefreshFailCount;
        AXP::Int32 mRefreshCount;
        AXP::Boolean mLogonSuccess;
        AXP::Boolean mRefreshSuccess;
    };

    class CWapDownloadTestRecord : public CTestRecord
    {
    public:

        AXP::ARESULT WriteToParcel(IN CONST AXP::Sp<AXP::CParcel> & parcel)
        {
            if (parcel == NULL)
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(AXP::String::Create(L"TestWorkModels.CWapDownloadTestRecord"))))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(CTestRecord::WriteToParcel(parcel)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mSpeedAvg)))
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

            if (AXP::AFAILED(CTestRecord::ReadFromParcel(parcel)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mSpeedAvg)))
                return AXP::AE_FAIL;

            return AXP::AS_OK;
        }

        AXP::Void Copy(IN CONST AXP::Sp<CWapDownloadTestRecord> & obj)
        {
            if (obj == NULL)
                return;

            CTestRecord::Copy(obj);

            mSpeedAvg = obj->mSpeedAvg;
        }

        AXP::Void SetNull()
        {
            CTestRecord::SetNull();

            mSpeedAvg = 0;
        }

        VIRTUAL AXP::Sp<AXP::String> ToString()
        {
            return AXP::String::Create(315, L"%.2f", mSpeedAvg);
        }

        VIRTUAL AXP::Sp<AXP::String> GetTypeName()
        {
            return AXP::String::Create(L"TestWorkModels.CWapDownloadTestRecord");
        }

    public:

        STATIC AXP::Sp<AXP::CObject> Create()
        {
            return new CWapDownloadTestRecord();
        }

    public:

        AXP::Double mSpeedAvg;
    };

    STATIC AXP::Boolean _TestWorkModels_CTestRecord_ = ObjectParcel::InsertMappingTable(L"TestWorkModels.CTestRecord", TestWorkModels::CTestRecord::Create);
    STATIC AXP::Boolean _TestWorkModels_CFtpHttpGroupInfo_ = ObjectParcel::InsertMappingTable(L"TestWorkModels.CFtpHttpGroupInfo", TestWorkModels::CFtpHttpGroupInfo::Create);
    STATIC AXP::Boolean _TestWorkModels_CFtpTestRecord_ = ObjectParcel::InsertMappingTable(L"TestWorkModels.CFtpTestRecord", TestWorkModels::CFtpTestRecord::Create);
    STATIC AXP::Boolean _TestWorkModels_CHttpTestRecord_ = ObjectParcel::InsertMappingTable(L"TestWorkModels.CHttpTestRecord", TestWorkModels::CHttpTestRecord::Create);
    STATIC AXP::Boolean _TestWorkModels_CMailTestRecord_ = ObjectParcel::InsertMappingTable(L"TestWorkModels.CMailTestRecord", TestWorkModels::CMailTestRecord::Create);
    STATIC AXP::Boolean _TestWorkModels_CPingTestRecord_ = ObjectParcel::InsertMappingTable(L"TestWorkModels.CPingTestRecord", TestWorkModels::CPingTestRecord::Create);
    STATIC AXP::Boolean _TestWorkModels_CTraceRouteTestRecord_ = ObjectParcel::InsertMappingTable(L"TestWorkModels.CTraceRouteTestRecord", TestWorkModels::CTraceRouteTestRecord::Create);
    STATIC AXP::Boolean _TestWorkModels_CVideoStreamTestRecord_ = ObjectParcel::InsertMappingTable(L"TestWorkModels.CVideoStreamTestRecord", TestWorkModels::CVideoStreamTestRecord::Create);
    STATIC AXP::Boolean _TestWorkModels_CHttpPageTestRecord_ = ObjectParcel::InsertMappingTable(L"TestWorkModels.CHttpPageTestRecord", TestWorkModels::CHttpPageTestRecord::Create);
    STATIC AXP::Boolean _TestWorkModels_CWapPageTestRecord_ = ObjectParcel::InsertMappingTable(L"TestWorkModels.CWapPageTestRecord", TestWorkModels::CWapPageTestRecord::Create);
    STATIC AXP::Boolean _TestWorkModels_CWapDownloadTestRecord_ = ObjectParcel::InsertMappingTable(L"TestWorkModels.CWapDownloadTestRecord", TestWorkModels::CWapDownloadTestRecord::Create);
}
#endif // __TESTRECORD_H__