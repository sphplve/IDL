
#ifndef __CONFIGPARAM_H__
#define __CONFIGPARAM_H__

#include "AXP/cplusplus/xplatform/include/type.h"
#include "AXP/cplusplus/xplatform/include/astring.h"
#include "AXP/cplusplus/xplatform/include/list.h"
#include "AXP/cplusplus/xplatform/include/Parcel.h"
#include "AXP/cplusplus/xplatform/include/parcelable.h"
#include "Models/ObjectParcel.h"
#include "TestItem.h"

namespace TestWorkModels
{
    class CCallConfig : public AXP::IParcelable, public AXP::CObject
    {
    public:

        AXP::ARESULT WriteToParcel(IN CONST AXP::Sp<AXP::CParcel> & parcel)
        {
            if (parcel == NULL)
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(AXP::String::Create(L"TestWorkModels.CCallConfig"))))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mIsCalling)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mTestCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mPhoneNumber)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mCallingTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mIntervalTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mConnectedTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mCalledTimeout)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mIsConnectedAlways)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mIsMos)))
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

            if (AXP::AFAILED(parcel->Read(mIsCalling)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mTestCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mPhoneNumber)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mCallingTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mIntervalTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mConnectedTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mCalledTimeout)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mIsConnectedAlways)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mIsMos)))
                return AXP::AE_FAIL;

            return AXP::AS_OK;
        }

        AXP::Void Copy(IN CONST AXP::Sp<CCallConfig> & obj)
        {
            if (obj == NULL)
                return;

            mIsCalling = obj->mIsCalling;
            mTestCount = obj->mTestCount;
            mPhoneNumber = obj->mPhoneNumber;
            mCallingTime = obj->mCallingTime;
            mIntervalTime = obj->mIntervalTime;
            mConnectedTime = obj->mConnectedTime;
            mCalledTimeout = obj->mCalledTimeout;
            mIsConnectedAlways = obj->mIsConnectedAlways;
            mIsMos = obj->mIsMos;
        }

        AXP::Void SetNull()
        {
            mIsCalling = 0;
            mTestCount = 0;
            mPhoneNumber = NULL;
            mCallingTime = 0;
            mIntervalTime = 0;
            mConnectedTime = 0;
            mCalledTimeout = 0;
            mIsConnectedAlways = 0;
            mIsMos = 0;
        }

        VIRTUAL AXP::Sp<AXP::String> ToString()
        {
            AXP::Sp<AXP::String> json = AXP::String::Create(L"{");
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mIsCalling\":\"%ls\",", (AXP::PCWStr)*json, mIsCalling ? L"true" : L"false");
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mTestCount\":\"%d\",", (AXP::PCWStr)*json, mTestCount);
            if (json == NULL)
                return NULL;

            if (mPhoneNumber == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mPhoneNumber\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mPhoneNumber->Length() + 40, L"%ls\"mPhoneNumber\":\"%ls\",", (AXP::PCWStr)*json, (AXP::PCWStr)*mPhoneNumber);
                if (json == NULL)
                    return NULL;
            }

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mCallingTime\":\"%lld\",", (AXP::PCWStr)*json, mCallingTime);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mIntervalTime\":\"%lld\",", (AXP::PCWStr)*json, mIntervalTime);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mConnectedTime\":\"%lld\",", (AXP::PCWStr)*json, mConnectedTime);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mCalledTimeout\":\"%lld\",", (AXP::PCWStr)*json, mCalledTimeout);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mIsConnectedAlways\":\"%ls\",", (AXP::PCWStr)*json, mIsConnectedAlways ? L"true" : L"false");
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mIsMos\":\"%ls\"", (AXP::PCWStr)*json, mIsMos ? L"true" : L"false");
            if (json == NULL)
                return NULL;

            return AXP::String::Create(json->Length() + 7, L"%ls}", (AXP::PCWStr)*json);
        }

        VIRTUAL AXP::Sp<AXP::String> GetTypeName()
        {
            return AXP::String::Create(L"TestWorkModels.CCallConfig");
        }

    public:

        STATIC AXP::Sp<AXP::CObject> Create()
        {
            return new CCallConfig();
        }

    public:

        AXP::Boolean mIsCalling;
        AXP::Int32 mTestCount;
        AXP::Sp<AXP::String> mPhoneNumber;
        AXP::Int64 mCallingTime;
        AXP::Int64 mIntervalTime;
        AXP::Int64 mConnectedTime;
        AXP::Int64 mCalledTimeout;
        AXP::Boolean mIsConnectedAlways;
        AXP::Boolean mIsMos;
    };

    class CFtpDownloadConfig : public AXP::IParcelable, public AXP::CObject
    {
    public:

        AXP::ARESULT WriteToParcel(IN CONST AXP::Sp<AXP::CParcel> & parcel)
        {
            if (parcel == NULL)
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(AXP::String::Create(L"TestWorkModels.CFtpDownloadConfig"))))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mDownloadMode)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mFtpIp)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mFtpUser)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mFtpPwd)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mRemotePath)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mTestCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mDownloadTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mTimeOut)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mIntervalTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mThreadCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mPppType)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mWorkMode)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mSaveOption)))
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

            if (AXP::AFAILED(parcel->Read(mDownloadMode)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mFtpIp)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mFtpUser)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mFtpPwd)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mRemotePath)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mTestCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mDownloadTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mTimeOut)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mIntervalTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mThreadCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mPppType)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mWorkMode)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mSaveOption)))
                return AXP::AE_FAIL;

            return AXP::AS_OK;
        }

        AXP::Void Copy(IN CONST AXP::Sp<CFtpDownloadConfig> & obj)
        {
            if (obj == NULL)
                return;

            mDownloadMode = obj->mDownloadMode;
            mFtpIp = obj->mFtpIp;
            mFtpUser = obj->mFtpUser;
            mFtpPwd = obj->mFtpPwd;
            mRemotePath = obj->mRemotePath;
            mTestCount = obj->mTestCount;
            mDownloadTime = obj->mDownloadTime;
            mTimeOut = obj->mTimeOut;
            mIntervalTime = obj->mIntervalTime;
            mThreadCount = obj->mThreadCount;
            mPppType = obj->mPppType;
            mWorkMode = obj->mWorkMode;
            mSaveOption = obj->mSaveOption;
        }

        AXP::Void SetNull()
        {
            mDownloadMode = 0;
            mFtpIp = NULL;
            mFtpUser = NULL;
            mFtpPwd = NULL;
            mRemotePath = NULL;
            mTestCount = 0;
            mDownloadTime = 0;
            mTimeOut = 0;
            mIntervalTime = 0;
            mThreadCount = 0;
            mPppType = 0;
            mWorkMode = 0;
            mSaveOption = 0;
        }

        VIRTUAL AXP::Sp<AXP::String> ToString()
        {
            AXP::Sp<AXP::String> json = AXP::String::Create(L"{");
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mDownloadMode\":\"%d\",", (AXP::PCWStr)*json, mDownloadMode);
            if (json == NULL)
                return NULL;

            if (mFtpIp == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mFtpIp\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mFtpIp->Length() + 40, L"%ls\"mFtpIp\":\"%ls\",", (AXP::PCWStr)*json, (AXP::PCWStr)*mFtpIp);
                if (json == NULL)
                    return NULL;
            }

            if (mFtpUser == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mFtpUser\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mFtpUser->Length() + 40, L"%ls\"mFtpUser\":\"%ls\",", (AXP::PCWStr)*json, (AXP::PCWStr)*mFtpUser);
                if (json == NULL)
                    return NULL;
            }

            if (mFtpPwd == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mFtpPwd\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mFtpPwd->Length() + 40, L"%ls\"mFtpPwd\":\"%ls\",", (AXP::PCWStr)*json, (AXP::PCWStr)*mFtpPwd);
                if (json == NULL)
                    return NULL;
            }

            if (mRemotePath == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mRemotePath\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mRemotePath->Length() + 40, L"%ls\"mRemotePath\":\"%ls\",", (AXP::PCWStr)*json, (AXP::PCWStr)*mRemotePath);
                if (json == NULL)
                    return NULL;
            }

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mTestCount\":\"%d\",", (AXP::PCWStr)*json, mTestCount);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mDownloadTime\":\"%d\",", (AXP::PCWStr)*json, mDownloadTime);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mTimeOut\":\"%d\",", (AXP::PCWStr)*json, mTimeOut);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mIntervalTime\":\"%d\",", (AXP::PCWStr)*json, mIntervalTime);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mThreadCount\":\"%d\",", (AXP::PCWStr)*json, mThreadCount);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mPppType\":\"%d\",", (AXP::PCWStr)*json, mPppType);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mWorkMode\":\"%d\",", (AXP::PCWStr)*json, mWorkMode);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mSaveOption\":\"%d\"", (AXP::PCWStr)*json, mSaveOption);
            if (json == NULL)
                return NULL;

            return AXP::String::Create(json->Length() + 7, L"%ls}", (AXP::PCWStr)*json);
        }

        VIRTUAL AXP::Sp<AXP::String> GetTypeName()
        {
            return AXP::String::Create(L"TestWorkModels.CFtpDownloadConfig");
        }

    public:

        STATIC AXP::Sp<AXP::CObject> Create()
        {
            return new CFtpDownloadConfig();
        }

    public:

        AXP::Int32 mDownloadMode;
        AXP::Sp<AXP::String> mFtpIp;
        AXP::Sp<AXP::String> mFtpUser;
        AXP::Sp<AXP::String> mFtpPwd;
        AXP::Sp<AXP::String> mRemotePath;
        AXP::Int32 mTestCount;
        AXP::Int32 mDownloadTime;
        AXP::Int32 mTimeOut;
        AXP::Int32 mIntervalTime;
        AXP::Int32 mThreadCount;
        AXP::Int32 mPppType;
        AXP::Int32 mWorkMode;
        AXP::Int32 mSaveOption;
    };

    class CFtpUploadConfig : public AXP::IParcelable, public AXP::CObject
    {
    public:

        AXP::ARESULT WriteToParcel(IN CONST AXP::Sp<AXP::CParcel> & parcel)
        {
            if (parcel == NULL)
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(AXP::String::Create(L"TestWorkModels.CFtpUploadConfig"))))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mUploadMode)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mFtpIp)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mFtpUser)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mFtpPwd)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mRemotePath)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mFilePath)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mTestCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mFileLength)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mUploadTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mTimeOut)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mIntervalTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mThreadCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mPppType)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mWorkMode)))
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

            if (AXP::AFAILED(parcel->Read(mUploadMode)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mFtpIp)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mFtpUser)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mFtpPwd)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mRemotePath)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mFilePath)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mTestCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mFileLength)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mUploadTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mTimeOut)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mIntervalTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mThreadCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mPppType)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mWorkMode)))
                return AXP::AE_FAIL;

            return AXP::AS_OK;
        }

        AXP::Void Copy(IN CONST AXP::Sp<CFtpUploadConfig> & obj)
        {
            if (obj == NULL)
                return;

            mUploadMode = obj->mUploadMode;
            mFtpIp = obj->mFtpIp;
            mFtpUser = obj->mFtpUser;
            mFtpPwd = obj->mFtpPwd;
            mRemotePath = obj->mRemotePath;
            mFilePath = obj->mFilePath;
            mTestCount = obj->mTestCount;
            mFileLength = obj->mFileLength;
            mUploadTime = obj->mUploadTime;
            mTimeOut = obj->mTimeOut;
            mIntervalTime = obj->mIntervalTime;
            mThreadCount = obj->mThreadCount;
            mPppType = obj->mPppType;
            mWorkMode = obj->mWorkMode;
        }

        AXP::Void SetNull()
        {
            mUploadMode = 0;
            mFtpIp = NULL;
            mFtpUser = NULL;
            mFtpPwd = NULL;
            mRemotePath = NULL;
            mFilePath = NULL;
            mTestCount = 0;
            mFileLength = 0;
            mUploadTime = 0;
            mTimeOut = 0;
            mIntervalTime = 0;
            mThreadCount = 0;
            mPppType = 0;
            mWorkMode = 0;
        }

        VIRTUAL AXP::Sp<AXP::String> ToString()
        {
            AXP::Sp<AXP::String> json = AXP::String::Create(L"{");
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mUploadMode\":\"%d\",", (AXP::PCWStr)*json, mUploadMode);
            if (json == NULL)
                return NULL;

            if (mFtpIp == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mFtpIp\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mFtpIp->Length() + 40, L"%ls\"mFtpIp\":\"%ls\",", (AXP::PCWStr)*json, (AXP::PCWStr)*mFtpIp);
                if (json == NULL)
                    return NULL;
            }

            if (mFtpUser == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mFtpUser\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mFtpUser->Length() + 40, L"%ls\"mFtpUser\":\"%ls\",", (AXP::PCWStr)*json, (AXP::PCWStr)*mFtpUser);
                if (json == NULL)
                    return NULL;
            }

            if (mFtpPwd == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mFtpPwd\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mFtpPwd->Length() + 40, L"%ls\"mFtpPwd\":\"%ls\",", (AXP::PCWStr)*json, (AXP::PCWStr)*mFtpPwd);
                if (json == NULL)
                    return NULL;
            }

            if (mRemotePath == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mRemotePath\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mRemotePath->Length() + 40, L"%ls\"mRemotePath\":\"%ls\",", (AXP::PCWStr)*json, (AXP::PCWStr)*mRemotePath);
                if (json == NULL)
                    return NULL;
            }

            if (mFilePath == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mFilePath\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mFilePath->Length() + 40, L"%ls\"mFilePath\":\"%ls\",", (AXP::PCWStr)*json, (AXP::PCWStr)*mFilePath);
                if (json == NULL)
                    return NULL;
            }

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mTestCount\":\"%d\",", (AXP::PCWStr)*json, mTestCount);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mFileLength\":\"%d\",", (AXP::PCWStr)*json, mFileLength);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mUploadTime\":\"%d\",", (AXP::PCWStr)*json, mUploadTime);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mTimeOut\":\"%d\",", (AXP::PCWStr)*json, mTimeOut);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mIntervalTime\":\"%d\",", (AXP::PCWStr)*json, mIntervalTime);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mThreadCount\":\"%d\",", (AXP::PCWStr)*json, mThreadCount);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mPppType\":\"%d\",", (AXP::PCWStr)*json, mPppType);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mWorkMode\":\"%d\"", (AXP::PCWStr)*json, mWorkMode);
            if (json == NULL)
                return NULL;

            return AXP::String::Create(json->Length() + 7, L"%ls}", (AXP::PCWStr)*json);
        }

        VIRTUAL AXP::Sp<AXP::String> GetTypeName()
        {
            return AXP::String::Create(L"TestWorkModels.CFtpUploadConfig");
        }

    public:

        STATIC AXP::Sp<AXP::CObject> Create()
        {
            return new CFtpUploadConfig();
        }

    public:

        AXP::Int32 mUploadMode;
        AXP::Sp<AXP::String> mFtpIp;
        AXP::Sp<AXP::String> mFtpUser;
        AXP::Sp<AXP::String> mFtpPwd;
        AXP::Sp<AXP::String> mRemotePath;
        AXP::Sp<AXP::String> mFilePath;
        AXP::Int32 mTestCount;
        AXP::Int32 mFileLength;
        AXP::Int32 mUploadTime;
        AXP::Int32 mTimeOut;
        AXP::Int32 mIntervalTime;
        AXP::Int32 mThreadCount;
        AXP::Int32 mPppType;
        AXP::Int32 mWorkMode;
    };

    class CHttpDownloadConfig : public AXP::IParcelable, public AXP::CObject
    {
    public:

        AXP::ARESULT WriteToParcel(IN CONST AXP::Sp<AXP::CParcel> & parcel)
        {
            if (parcel == NULL)
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(AXP::String::Create(L"TestWorkModels.CHttpDownloadConfig"))))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mTestCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mDownloadUrl)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mTimeOut)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mIntervalTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mThreadCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mDownloadMode)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mLowSpeedTimeOut)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mPppType)))
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

            if (AXP::AFAILED(parcel->Read(mTestCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mDownloadUrl)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mTimeOut)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mIntervalTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mThreadCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mDownloadMode)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mLowSpeedTimeOut)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mPppType)))
                return AXP::AE_FAIL;

            return AXP::AS_OK;
        }

        AXP::Void Copy(IN CONST AXP::Sp<CHttpDownloadConfig> & obj)
        {
            if (obj == NULL)
                return;

            mTestCount = obj->mTestCount;
            mDownloadUrl = obj->mDownloadUrl;
            mTimeOut = obj->mTimeOut;
            mIntervalTime = obj->mIntervalTime;
            mThreadCount = obj->mThreadCount;
            mDownloadMode = obj->mDownloadMode;
            mLowSpeedTimeOut = obj->mLowSpeedTimeOut;
            mPppType = obj->mPppType;
        }

        AXP::Void SetNull()
        {
            mTestCount = 0;
            mDownloadUrl = NULL;
            mTimeOut = 0;
            mIntervalTime = 0;
            mThreadCount = 0;
            mDownloadMode = 0;
            mLowSpeedTimeOut = 0;
            mPppType = 0;
        }

        VIRTUAL AXP::Sp<AXP::String> ToString()
        {
            AXP::Sp<AXP::String> json = AXP::String::Create(L"{");
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mTestCount\":\"%d\",", (AXP::PCWStr)*json, mTestCount);
            if (json == NULL)
                return NULL;

            if (mDownloadUrl == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mDownloadUrl\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mDownloadUrl->Length() + 40, L"%ls\"mDownloadUrl\":\"%ls\",", (AXP::PCWStr)*json, (AXP::PCWStr)*mDownloadUrl);
                if (json == NULL)
                    return NULL;
            }

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mTimeOut\":\"%d\",", (AXP::PCWStr)*json, mTimeOut);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mIntervalTime\":\"%d\",", (AXP::PCWStr)*json, mIntervalTime);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mThreadCount\":\"%d\",", (AXP::PCWStr)*json, mThreadCount);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mDownloadMode\":\"%d\",", (AXP::PCWStr)*json, mDownloadMode);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mLowSpeedTimeOut\":\"%d\",", (AXP::PCWStr)*json, mLowSpeedTimeOut);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mPppType\":\"%d\"", (AXP::PCWStr)*json, mPppType);
            if (json == NULL)
                return NULL;

            return AXP::String::Create(json->Length() + 7, L"%ls}", (AXP::PCWStr)*json);
        }

        VIRTUAL AXP::Sp<AXP::String> GetTypeName()
        {
            return AXP::String::Create(L"TestWorkModels.CHttpDownloadConfig");
        }

    public:

        STATIC AXP::Sp<AXP::CObject> Create()
        {
            return new CHttpDownloadConfig();
        }

    public:

        AXP::Int32 mTestCount;
        AXP::Sp<AXP::String> mDownloadUrl;
        AXP::Int32 mTimeOut;
        AXP::Int32 mIntervalTime;
        AXP::Int32 mThreadCount;
        AXP::Int32 mDownloadMode;
        AXP::Int32 mLowSpeedTimeOut;
        AXP::Int32 mPppType;
    };

    class CHttpPageConfig : public AXP::IParcelable, public AXP::CObject
    {
    public:

        AXP::ARESULT WriteToParcel(IN CONST AXP::Sp<AXP::CParcel> & parcel)
        {
            if (parcel == NULL)
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(AXP::String::Create(L"TestWorkModels.CHttpPageConfig"))))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mTestCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mPageUrl)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mTimeOut)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mIntervalTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mPppType)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mTestMode)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mLowSpeedTimeOut)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mIsLoadImage)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mIsCleanCache)))
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

            if (AXP::AFAILED(parcel->Read(mTestCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mPageUrl)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mTimeOut)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mIntervalTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mPppType)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mTestMode)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mLowSpeedTimeOut)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mIsLoadImage)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mIsCleanCache)))
                return AXP::AE_FAIL;

            return AXP::AS_OK;
        }

        AXP::Void Copy(IN CONST AXP::Sp<CHttpPageConfig> & obj)
        {
            if (obj == NULL)
                return;

            mTestCount = obj->mTestCount;
            mPageUrl = obj->mPageUrl;
            mTimeOut = obj->mTimeOut;
            mIntervalTime = obj->mIntervalTime;
            mPppType = obj->mPppType;
            mTestMode = obj->mTestMode;
            mLowSpeedTimeOut = obj->mLowSpeedTimeOut;
            mIsLoadImage = obj->mIsLoadImage;
            mIsCleanCache = obj->mIsCleanCache;
        }

        AXP::Void SetNull()
        {
            mTestCount = 0;
            mPageUrl = NULL;
            mTimeOut = 0;
            mIntervalTime = 0;
            mPppType = 0;
            mTestMode = 0;
            mLowSpeedTimeOut = 0;
            mIsLoadImage = 0;
            mIsCleanCache = 0;
        }

        VIRTUAL AXP::Sp<AXP::String> ToString()
        {
            AXP::Sp<AXP::String> json = AXP::String::Create(L"{");
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mTestCount\":\"%d\",", (AXP::PCWStr)*json, mTestCount);
            if (json == NULL)
                return NULL;

            if (mPageUrl == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mPageUrl\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mPageUrl->Length() + 40, L"%ls\"mPageUrl\":\"%ls\",", (AXP::PCWStr)*json, (AXP::PCWStr)*mPageUrl);
                if (json == NULL)
                    return NULL;
            }

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mTimeOut\":\"%d\",", (AXP::PCWStr)*json, mTimeOut);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mIntervalTime\":\"%d\",", (AXP::PCWStr)*json, mIntervalTime);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mPppType\":\"%d\",", (AXP::PCWStr)*json, mPppType);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mTestMode\":\"%d\",", (AXP::PCWStr)*json, mTestMode);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mLowSpeedTimeOut\":\"%d\",", (AXP::PCWStr)*json, mLowSpeedTimeOut);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mIsLoadImage\":\"%ls\",", (AXP::PCWStr)*json, mIsLoadImage ? L"true" : L"false");
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mIsCleanCache\":\"%ls\"", (AXP::PCWStr)*json, mIsCleanCache ? L"true" : L"false");
            if (json == NULL)
                return NULL;

            return AXP::String::Create(json->Length() + 7, L"%ls}", (AXP::PCWStr)*json);
        }

        VIRTUAL AXP::Sp<AXP::String> GetTypeName()
        {
            return AXP::String::Create(L"TestWorkModels.CHttpPageConfig");
        }

    public:

        STATIC AXP::Sp<AXP::CObject> Create()
        {
            return new CHttpPageConfig();
        }

    public:

        AXP::Int32 mTestCount;
        AXP::Sp<AXP::String> mPageUrl;
        AXP::Int32 mTimeOut;
        AXP::Int32 mIntervalTime;
        AXP::Int32 mPppType;
        AXP::Int32 mTestMode;
        AXP::Int32 mLowSpeedTimeOut;
        AXP::Boolean mIsLoadImage;
        AXP::Boolean mIsCleanCache;
    };

    class CHttpUploadConfig : public AXP::IParcelable, public AXP::CObject
    {
    public:

        AXP::ARESULT WriteToParcel(IN CONST AXP::Sp<AXP::CParcel> & parcel)
        {
            if (parcel == NULL)
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(AXP::String::Create(L"TestWorkModels.CHttpUploadConfig"))))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mTestCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mUploadUrl)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mFilePath)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mFileLength)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mUploadTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mIntervalTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mLowSpeedTimeOut)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mUploadMode)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mPppType)))
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

            if (AXP::AFAILED(parcel->Read(mTestCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mUploadUrl)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mFilePath)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mFileLength)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mUploadTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mIntervalTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mLowSpeedTimeOut)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mUploadMode)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mPppType)))
                return AXP::AE_FAIL;

            return AXP::AS_OK;
        }

        AXP::Void Copy(IN CONST AXP::Sp<CHttpUploadConfig> & obj)
        {
            if (obj == NULL)
                return;

            mTestCount = obj->mTestCount;
            mUploadUrl = obj->mUploadUrl;
            mFilePath = obj->mFilePath;
            mFileLength = obj->mFileLength;
            mUploadTime = obj->mUploadTime;
            mIntervalTime = obj->mIntervalTime;
            mLowSpeedTimeOut = obj->mLowSpeedTimeOut;
            mUploadMode = obj->mUploadMode;
            mPppType = obj->mPppType;
        }

        AXP::Void SetNull()
        {
            mTestCount = 0;
            mUploadUrl = NULL;
            mFilePath = NULL;
            mFileLength = 0;
            mUploadTime = 0;
            mIntervalTime = 0;
            mLowSpeedTimeOut = 0;
            mUploadMode = 0;
            mPppType = 0;
        }

        VIRTUAL AXP::Sp<AXP::String> ToString()
        {
            AXP::Sp<AXP::String> json = AXP::String::Create(L"{");
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mTestCount\":\"%d\",", (AXP::PCWStr)*json, mTestCount);
            if (json == NULL)
                return NULL;

            if (mUploadUrl == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mUploadUrl\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mUploadUrl->Length() + 40, L"%ls\"mUploadUrl\":\"%ls\",", (AXP::PCWStr)*json, (AXP::PCWStr)*mUploadUrl);
                if (json == NULL)
                    return NULL;
            }

            if (mFilePath == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mFilePath\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mFilePath->Length() + 40, L"%ls\"mFilePath\":\"%ls\",", (AXP::PCWStr)*json, (AXP::PCWStr)*mFilePath);
                if (json == NULL)
                    return NULL;
            }

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mFileLength\":\"%d\",", (AXP::PCWStr)*json, mFileLength);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mUploadTime\":\"%d\",", (AXP::PCWStr)*json, mUploadTime);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mIntervalTime\":\"%d\",", (AXP::PCWStr)*json, mIntervalTime);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mLowSpeedTimeOut\":\"%d\",", (AXP::PCWStr)*json, mLowSpeedTimeOut);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mUploadMode\":\"%d\",", (AXP::PCWStr)*json, mUploadMode);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mPppType\":\"%d\"", (AXP::PCWStr)*json, mPppType);
            if (json == NULL)
                return NULL;

            return AXP::String::Create(json->Length() + 7, L"%ls}", (AXP::PCWStr)*json);
        }

        VIRTUAL AXP::Sp<AXP::String> GetTypeName()
        {
            return AXP::String::Create(L"TestWorkModels.CHttpUploadConfig");
        }

    public:

        STATIC AXP::Sp<AXP::CObject> Create()
        {
            return new CHttpUploadConfig();
        }

    public:

        AXP::Int32 mTestCount;
        AXP::Sp<AXP::String> mUploadUrl;
        AXP::Sp<AXP::String> mFilePath;
        AXP::Int32 mFileLength;
        AXP::Int32 mUploadTime;
        AXP::Int32 mIntervalTime;
        AXP::Int32 mLowSpeedTimeOut;
        AXP::Int32 mUploadMode;
        AXP::Int32 mPppType;
    };

    class CIdleConfig : public AXP::IParcelable, public AXP::CObject
    {
    public:

        AXP::ARESULT WriteToParcel(IN CONST AXP::Sp<AXP::CParcel> & parcel)
        {
            if (parcel == NULL)
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(AXP::String::Create(L"TestWorkModels.CIdleConfig"))))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mTestTime)))
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

            if (AXP::AFAILED(parcel->Read(mTestTime)))
                return AXP::AE_FAIL;

            return AXP::AS_OK;
        }

        AXP::Void Copy(IN CONST AXP::Sp<CIdleConfig> & obj)
        {
            if (obj == NULL)
                return;

            mTestTime = obj->mTestTime;
        }

        AXP::Void SetNull()
        {
            mTestTime = 0;
        }

        VIRTUAL AXP::Sp<AXP::String> ToString()
        {
            return AXP::String::Create(32, L"%lld", mTestTime);
        }

        VIRTUAL AXP::Sp<AXP::String> GetTypeName()
        {
            return AXP::String::Create(L"TestWorkModels.CIdleConfig");
        }

    public:

        STATIC AXP::Sp<AXP::CObject> Create()
        {
            return new CIdleConfig();
        }

    public:

        AXP::Int64 mTestTime;
    };

    class CPingConfig : public AXP::IParcelable, public AXP::CObject
    {
    public:

        AXP::ARESULT WriteToParcel(IN CONST AXP::Sp<AXP::CParcel> & parcel)
        {
            if (parcel == NULL)
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(AXP::String::Create(L"TestWorkModels.CPingConfig"))))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mTestCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mIPAddress)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mPackageSize)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mIntervalTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mTimeOut)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mTTL)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mPppType)))
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

            if (AXP::AFAILED(parcel->Read(mTestCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mIPAddress)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mPackageSize)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mIntervalTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mTimeOut)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mTTL)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mPppType)))
                return AXP::AE_FAIL;

            return AXP::AS_OK;
        }

        AXP::Void Copy(IN CONST AXP::Sp<CPingConfig> & obj)
        {
            if (obj == NULL)
                return;

            mTestCount = obj->mTestCount;
            mIPAddress = obj->mIPAddress;
            mPackageSize = obj->mPackageSize;
            mIntervalTime = obj->mIntervalTime;
            mTimeOut = obj->mTimeOut;
            mTTL = obj->mTTL;
            mPppType = obj->mPppType;
        }

        AXP::Void SetNull()
        {
            mTestCount = 0;
            mIPAddress = NULL;
            mPackageSize = 0;
            mIntervalTime = 0;
            mTimeOut = 0;
            mTTL = 0;
            mPppType = 0;
        }

        VIRTUAL AXP::Sp<AXP::String> ToString()
        {
            AXP::Sp<AXP::String> json = AXP::String::Create(L"{");
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mTestCount\":\"%d\",", (AXP::PCWStr)*json, mTestCount);
            if (json == NULL)
                return NULL;

            if (mIPAddress == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mIPAddress\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mIPAddress->Length() + 40, L"%ls\"mIPAddress\":\"%ls\",", (AXP::PCWStr)*json, (AXP::PCWStr)*mIPAddress);
                if (json == NULL)
                    return NULL;
            }

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mPackageSize\":\"%d\",", (AXP::PCWStr)*json, mPackageSize);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mIntervalTime\":\"%d\",", (AXP::PCWStr)*json, mIntervalTime);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mTimeOut\":\"%d\",", (AXP::PCWStr)*json, mTimeOut);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mTTL\":\"%d\",", (AXP::PCWStr)*json, mTTL);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mPppType\":\"%d\"", (AXP::PCWStr)*json, mPppType);
            if (json == NULL)
                return NULL;

            return AXP::String::Create(json->Length() + 7, L"%ls}", (AXP::PCWStr)*json);
        }

        VIRTUAL AXP::Sp<AXP::String> GetTypeName()
        {
            return AXP::String::Create(L"TestWorkModels.CPingConfig");
        }

    public:

        STATIC AXP::Sp<AXP::CObject> Create()
        {
            return new CPingConfig();
        }

    public:

        AXP::Int32 mTestCount;
        AXP::Sp<AXP::String> mIPAddress;
        AXP::Int32 mPackageSize;
        AXP::Int32 mIntervalTime;
        AXP::Int32 mTimeOut;
        AXP::Int32 mTTL;
        AXP::Int32 mPppType;
    };

    class CReceiveEmailConfig : public AXP::IParcelable, public AXP::CObject
    {
    public:

        AXP::ARESULT WriteToParcel(IN CONST AXP::Sp<AXP::CParcel> & parcel)
        {
            if (parcel == NULL)
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(AXP::String::Create(L"TestWorkModels.CReceiveEmailConfig"))))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mTestCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mPop3Addr)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mMailAddr)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mPassword)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mPop3Port)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mServerType)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mTimeOut)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mIntervalTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mPppType)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mEncryMode)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mLowSpeedTimeout)))
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

            if (AXP::AFAILED(parcel->Read(mTestCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mPop3Addr)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mMailAddr)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mPassword)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mPop3Port)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mServerType)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mTimeOut)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mIntervalTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mPppType)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mEncryMode)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mLowSpeedTimeout)))
                return AXP::AE_FAIL;

            return AXP::AS_OK;
        }

        AXP::Void Copy(IN CONST AXP::Sp<CReceiveEmailConfig> & obj)
        {
            if (obj == NULL)
                return;

            mTestCount = obj->mTestCount;
            mPop3Addr = obj->mPop3Addr;
            mMailAddr = obj->mMailAddr;
            mPassword = obj->mPassword;
            mPop3Port = obj->mPop3Port;
            mServerType = obj->mServerType;
            mTimeOut = obj->mTimeOut;
            mIntervalTime = obj->mIntervalTime;
            mPppType = obj->mPppType;
            mEncryMode = obj->mEncryMode;
            mLowSpeedTimeout = obj->mLowSpeedTimeout;
        }

        AXP::Void SetNull()
        {
            mTestCount = 0;
            mPop3Addr = NULL;
            mMailAddr = NULL;
            mPassword = NULL;
            mPop3Port = 0;
            mServerType = 0;
            mTimeOut = 0;
            mIntervalTime = 0;
            mPppType = 0;
            mEncryMode = 0;
            mLowSpeedTimeout = 0;
        }

        VIRTUAL AXP::Sp<AXP::String> ToString()
        {
            AXP::Sp<AXP::String> json = AXP::String::Create(L"{");
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mTestCount\":\"%d\",", (AXP::PCWStr)*json, mTestCount);
            if (json == NULL)
                return NULL;

            if (mPop3Addr == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mPop3Addr\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mPop3Addr->Length() + 40, L"%ls\"mPop3Addr\":\"%ls\",", (AXP::PCWStr)*json, (AXP::PCWStr)*mPop3Addr);
                if (json == NULL)
                    return NULL;
            }

            if (mMailAddr == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mMailAddr\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mMailAddr->Length() + 40, L"%ls\"mMailAddr\":\"%ls\",", (AXP::PCWStr)*json, (AXP::PCWStr)*mMailAddr);
                if (json == NULL)
                    return NULL;
            }

            if (mPassword == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mPassword\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mPassword->Length() + 40, L"%ls\"mPassword\":\"%ls\",", (AXP::PCWStr)*json, (AXP::PCWStr)*mPassword);
                if (json == NULL)
                    return NULL;
            }

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mPop3Port\":\"%d\",", (AXP::PCWStr)*json, mPop3Port);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mServerType\":\"%d\",", (AXP::PCWStr)*json, mServerType);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mTimeOut\":\"%d\",", (AXP::PCWStr)*json, mTimeOut);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mIntervalTime\":\"%d\",", (AXP::PCWStr)*json, mIntervalTime);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mPppType\":\"%d\",", (AXP::PCWStr)*json, mPppType);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mEncryMode\":\"%d\",", (AXP::PCWStr)*json, mEncryMode);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mLowSpeedTimeout\":\"%d\"", (AXP::PCWStr)*json, mLowSpeedTimeout);
            if (json == NULL)
                return NULL;

            return AXP::String::Create(json->Length() + 7, L"%ls}", (AXP::PCWStr)*json);
        }

        VIRTUAL AXP::Sp<AXP::String> GetTypeName()
        {
            return AXP::String::Create(L"TestWorkModels.CReceiveEmailConfig");
        }

    public:

        STATIC AXP::Sp<AXP::CObject> Create()
        {
            return new CReceiveEmailConfig();
        }

    public:

        AXP::Int32 mTestCount;
        AXP::Sp<AXP::String> mPop3Addr;
        AXP::Sp<AXP::String> mMailAddr;
        AXP::Sp<AXP::String> mPassword;
        AXP::Int32 mPop3Port;
        AXP::Int32 mServerType;
        AXP::Int32 mTimeOut;
        AXP::Int32 mIntervalTime;
        AXP::Int32 mPppType;
        AXP::Int32 mEncryMode;
        AXP::Int32 mLowSpeedTimeout;
    };

    class CSendEmailConfig : public AXP::IParcelable, public AXP::CObject
    {
    public:

        AXP::ARESULT WriteToParcel(IN CONST AXP::Sp<AXP::CParcel> & parcel)
        {
            if (parcel == NULL)
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(AXP::String::Create(L"TestWorkModels.CSendEmailConfig"))))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mTestCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mSmtpAddr)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mMailAddr)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mPassword)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mReceiveMailAddr)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mMailSubject)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mMailBody)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mSmtpPort)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mEncryMode)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mTimeOut)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mIntervalTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mLowSpeedTimeout)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mPppType)))
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

            if (AXP::AFAILED(parcel->Read(mTestCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mSmtpAddr)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mMailAddr)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mPassword)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mReceiveMailAddr)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mMailSubject)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mMailBody)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mSmtpPort)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mEncryMode)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mTimeOut)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mIntervalTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mLowSpeedTimeout)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mPppType)))
                return AXP::AE_FAIL;

            return AXP::AS_OK;
        }

        AXP::Void Copy(IN CONST AXP::Sp<CSendEmailConfig> & obj)
        {
            if (obj == NULL)
                return;

            mTestCount = obj->mTestCount;
            mSmtpAddr = obj->mSmtpAddr;
            mMailAddr = obj->mMailAddr;
            mPassword = obj->mPassword;
            mReceiveMailAddr = obj->mReceiveMailAddr;
            mMailSubject = obj->mMailSubject;
            mMailBody = obj->mMailBody;
            mSmtpPort = obj->mSmtpPort;
            mEncryMode = obj->mEncryMode;
            mTimeOut = obj->mTimeOut;
            mIntervalTime = obj->mIntervalTime;
            mLowSpeedTimeout = obj->mLowSpeedTimeout;
            mPppType = obj->mPppType;
        }

        AXP::Void SetNull()
        {
            mTestCount = 0;
            mSmtpAddr = NULL;
            mMailAddr = NULL;
            mPassword = NULL;
            mReceiveMailAddr = NULL;
            mMailSubject = NULL;
            mMailBody = NULL;
            mSmtpPort = 0;
            mEncryMode = 0;
            mTimeOut = 0;
            mIntervalTime = 0;
            mLowSpeedTimeout = 0;
            mPppType = 0;
        }

        VIRTUAL AXP::Sp<AXP::String> ToString()
        {
            AXP::Sp<AXP::String> json = AXP::String::Create(L"{");
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mTestCount\":\"%d\",", (AXP::PCWStr)*json, mTestCount);
            if (json == NULL)
                return NULL;

            if (mSmtpAddr == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mSmtpAddr\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mSmtpAddr->Length() + 40, L"%ls\"mSmtpAddr\":\"%ls\",", (AXP::PCWStr)*json, (AXP::PCWStr)*mSmtpAddr);
                if (json == NULL)
                    return NULL;
            }

            if (mMailAddr == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mMailAddr\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mMailAddr->Length() + 40, L"%ls\"mMailAddr\":\"%ls\",", (AXP::PCWStr)*json, (AXP::PCWStr)*mMailAddr);
                if (json == NULL)
                    return NULL;
            }

            if (mPassword == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mPassword\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mPassword->Length() + 40, L"%ls\"mPassword\":\"%ls\",", (AXP::PCWStr)*json, (AXP::PCWStr)*mPassword);
                if (json == NULL)
                    return NULL;
            }

            if (mReceiveMailAddr == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mReceiveMailAddr\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mReceiveMailAddr->Length() + 40, L"%ls\"mReceiveMailAddr\":\"%ls\",", (AXP::PCWStr)*json, (AXP::PCWStr)*mReceiveMailAddr);
                if (json == NULL)
                    return NULL;
            }

            if (mMailSubject == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mMailSubject\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mMailSubject->Length() + 40, L"%ls\"mMailSubject\":\"%ls\",", (AXP::PCWStr)*json, (AXP::PCWStr)*mMailSubject);
                if (json == NULL)
                    return NULL;
            }

            if (mMailBody == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mMailBody\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mMailBody->Length() + 40, L"%ls\"mMailBody\":\"%ls\",", (AXP::PCWStr)*json, (AXP::PCWStr)*mMailBody);
                if (json == NULL)
                    return NULL;
            }

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mSmtpPort\":\"%d\",", (AXP::PCWStr)*json, mSmtpPort);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mEncryMode\":\"%d\",", (AXP::PCWStr)*json, mEncryMode);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mTimeOut\":\"%d\",", (AXP::PCWStr)*json, mTimeOut);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mIntervalTime\":\"%d\",", (AXP::PCWStr)*json, mIntervalTime);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mLowSpeedTimeout\":\"%d\",", (AXP::PCWStr)*json, mLowSpeedTimeout);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mPppType\":\"%d\"", (AXP::PCWStr)*json, mPppType);
            if (json == NULL)
                return NULL;

            return AXP::String::Create(json->Length() + 7, L"%ls}", (AXP::PCWStr)*json);
        }

        VIRTUAL AXP::Sp<AXP::String> GetTypeName()
        {
            return AXP::String::Create(L"TestWorkModels.CSendEmailConfig");
        }

    public:

        STATIC AXP::Sp<AXP::CObject> Create()
        {
            return new CSendEmailConfig();
        }

    public:

        AXP::Int32 mTestCount;
        AXP::Sp<AXP::String> mSmtpAddr;
        AXP::Sp<AXP::String> mMailAddr;
        AXP::Sp<AXP::String> mPassword;
        AXP::Sp<AXP::String> mReceiveMailAddr;
        AXP::Sp<AXP::String> mMailSubject;
        AXP::Sp<AXP::String> mMailBody;
        AXP::Int32 mSmtpPort;
        AXP::Int32 mEncryMode;
        AXP::Int32 mTimeOut;
        AXP::Int32 mIntervalTime;
        AXP::Int32 mLowSpeedTimeout;
        AXP::Int32 mPppType;
    };

    class CSmsReceiveConfig : public AXP::IParcelable, public AXP::CObject
    {
    public:

        AXP::ARESULT WriteToParcel(IN CONST AXP::Sp<AXP::CParcel> & parcel)
        {
            if (parcel == NULL)
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(AXP::String::Create(L"TestWorkModels.CSmsReceiveConfig"))))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mReceiveCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mTimeOut)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mIntervalTime)))
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

            if (AXP::AFAILED(parcel->Read(mReceiveCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mTimeOut)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mIntervalTime)))
                return AXP::AE_FAIL;

            return AXP::AS_OK;
        }

        AXP::Void Copy(IN CONST AXP::Sp<CSmsReceiveConfig> & obj)
        {
            if (obj == NULL)
                return;

            mReceiveCount = obj->mReceiveCount;
            mTimeOut = obj->mTimeOut;
            mIntervalTime = obj->mIntervalTime;
        }

        AXP::Void SetNull()
        {
            mReceiveCount = 0;
            mTimeOut = 0;
            mIntervalTime = 0;
        }

        VIRTUAL AXP::Sp<AXP::String> ToString()
        {
            AXP::Sp<AXP::String> json = AXP::String::Create(L"{");
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mReceiveCount\":\"%d\",", (AXP::PCWStr)*json, mReceiveCount);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mTimeOut\":\"%d\",", (AXP::PCWStr)*json, mTimeOut);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mIntervalTime\":\"%d\"", (AXP::PCWStr)*json, mIntervalTime);
            if (json == NULL)
                return NULL;

            return AXP::String::Create(json->Length() + 7, L"%ls}", (AXP::PCWStr)*json);
        }

        VIRTUAL AXP::Sp<AXP::String> GetTypeName()
        {
            return AXP::String::Create(L"TestWorkModels.CSmsReceiveConfig");
        }

    public:

        STATIC AXP::Sp<AXP::CObject> Create()
        {
            return new CSmsReceiveConfig();
        }

    public:

        AXP::Int32 mReceiveCount;
        AXP::Int32 mTimeOut;
        AXP::Int32 mIntervalTime;
    };

    class CSmsSendConfig : public AXP::IParcelable, public AXP::CObject
    {
    public:

        AXP::ARESULT WriteToParcel(IN CONST AXP::Sp<AXP::CParcel> & parcel)
        {
            if (parcel == NULL)
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(AXP::String::Create(L"TestWorkModels.CSmsSendConfig"))))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mSendCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mCenterNumber)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mReceiveNumber)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mContent)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mIntervalTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mTimeOut)))
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

            if (AXP::AFAILED(parcel->Read(mSendCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mCenterNumber)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mReceiveNumber)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mContent)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mIntervalTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mTimeOut)))
                return AXP::AE_FAIL;

            return AXP::AS_OK;
        }

        AXP::Void Copy(IN CONST AXP::Sp<CSmsSendConfig> & obj)
        {
            if (obj == NULL)
                return;

            mSendCount = obj->mSendCount;
            mCenterNumber = obj->mCenterNumber;
            mReceiveNumber = obj->mReceiveNumber;
            mContent = obj->mContent;
            mIntervalTime = obj->mIntervalTime;
            mTimeOut = obj->mTimeOut;
        }

        AXP::Void SetNull()
        {
            mSendCount = 0;
            mCenterNumber = NULL;
            mReceiveNumber = NULL;
            mContent = NULL;
            mIntervalTime = 0;
            mTimeOut = 0;
        }

        VIRTUAL AXP::Sp<AXP::String> ToString()
        {
            AXP::Sp<AXP::String> json = AXP::String::Create(L"{");
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mSendCount\":\"%d\",", (AXP::PCWStr)*json, mSendCount);
            if (json == NULL)
                return NULL;

            if (mCenterNumber == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mCenterNumber\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mCenterNumber->Length() + 40, L"%ls\"mCenterNumber\":\"%ls\",", (AXP::PCWStr)*json, (AXP::PCWStr)*mCenterNumber);
                if (json == NULL)
                    return NULL;
            }

            if (mReceiveNumber == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mReceiveNumber\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mReceiveNumber->Length() + 40, L"%ls\"mReceiveNumber\":\"%ls\",", (AXP::PCWStr)*json, (AXP::PCWStr)*mReceiveNumber);
                if (json == NULL)
                    return NULL;
            }

            if (mContent == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mContent\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mContent->Length() + 40, L"%ls\"mContent\":\"%ls\",", (AXP::PCWStr)*json, (AXP::PCWStr)*mContent);
                if (json == NULL)
                    return NULL;
            }

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mIntervalTime\":\"%d\",", (AXP::PCWStr)*json, mIntervalTime);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mTimeOut\":\"%d\"", (AXP::PCWStr)*json, mTimeOut);
            if (json == NULL)
                return NULL;

            return AXP::String::Create(json->Length() + 7, L"%ls}", (AXP::PCWStr)*json);
        }

        VIRTUAL AXP::Sp<AXP::String> GetTypeName()
        {
            return AXP::String::Create(L"TestWorkModels.CSmsSendConfig");
        }

    public:

        STATIC AXP::Sp<AXP::CObject> Create()
        {
            return new CSmsSendConfig();
        }

    public:

        AXP::Int32 mSendCount;
        AXP::Sp<AXP::String> mCenterNumber;
        AXP::Sp<AXP::String> mReceiveNumber;
        AXP::Sp<AXP::String> mContent;
        AXP::Int32 mIntervalTime;
        AXP::Int32 mTimeOut;
    };

    class CTraceRouteConfig : public AXP::IParcelable, public AXP::CObject
    {
    public:

        AXP::ARESULT WriteToParcel(IN CONST AXP::Sp<AXP::CParcel> & parcel)
        {
            if (parcel == NULL)
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(AXP::String::Create(L"TestWorkModels.CTraceRouteConfig"))))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mTestCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mTraceHost)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mPackageSize)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mIntervalTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mHopTimeOut)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mHopIntervalTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mHopDetectTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mPppType)))
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

            if (AXP::AFAILED(parcel->Read(mTestCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mTraceHost)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mPackageSize)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mIntervalTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mHopTimeOut)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mHopIntervalTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mHopDetectTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mPppType)))
                return AXP::AE_FAIL;

            return AXP::AS_OK;
        }

        AXP::Void Copy(IN CONST AXP::Sp<CTraceRouteConfig> & obj)
        {
            if (obj == NULL)
                return;

            mTestCount = obj->mTestCount;
            mTraceHost = obj->mTraceHost;
            mPackageSize = obj->mPackageSize;
            mIntervalTime = obj->mIntervalTime;
            mHopTimeOut = obj->mHopTimeOut;
            mHopIntervalTime = obj->mHopIntervalTime;
            mHopDetectTime = obj->mHopDetectTime;
            mPppType = obj->mPppType;
        }

        AXP::Void SetNull()
        {
            mTestCount = 0;
            mTraceHost = NULL;
            mPackageSize = 0;
            mIntervalTime = 0;
            mHopTimeOut = 0;
            mHopIntervalTime = 0;
            mHopDetectTime = 0;
            mPppType = 0;
        }

        VIRTUAL AXP::Sp<AXP::String> ToString()
        {
            AXP::Sp<AXP::String> json = AXP::String::Create(L"{");
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mTestCount\":\"%d\",", (AXP::PCWStr)*json, mTestCount);
            if (json == NULL)
                return NULL;

            if (mTraceHost == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mTraceHost\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mTraceHost->Length() + 40, L"%ls\"mTraceHost\":\"%ls\",", (AXP::PCWStr)*json, (AXP::PCWStr)*mTraceHost);
                if (json == NULL)
                    return NULL;
            }

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mPackageSize\":\"%d\",", (AXP::PCWStr)*json, mPackageSize);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mIntervalTime\":\"%d\",", (AXP::PCWStr)*json, mIntervalTime);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mHopTimeOut\":\"%d\",", (AXP::PCWStr)*json, mHopTimeOut);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mHopIntervalTime\":\"%d\",", (AXP::PCWStr)*json, mHopIntervalTime);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mHopDetectTime\":\"%d\",", (AXP::PCWStr)*json, mHopDetectTime);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mPppType\":\"%d\"", (AXP::PCWStr)*json, mPppType);
            if (json == NULL)
                return NULL;

            return AXP::String::Create(json->Length() + 7, L"%ls}", (AXP::PCWStr)*json);
        }

        VIRTUAL AXP::Sp<AXP::String> GetTypeName()
        {
            return AXP::String::Create(L"TestWorkModels.CTraceRouteConfig");
        }

    public:

        STATIC AXP::Sp<AXP::CObject> Create()
        {
            return new CTraceRouteConfig();
        }

    public:

        AXP::Int32 mTestCount;
        AXP::Sp<AXP::String> mTraceHost;
        AXP::Int32 mPackageSize;
        AXP::Int32 mIntervalTime;
        AXP::Int32 mHopTimeOut;
        AXP::Int32 mHopIntervalTime;
        AXP::Int32 mHopDetectTime;
        AXP::Int32 mPppType;
    };

    class CVideoStreamingConfig : public AXP::IParcelable, public AXP::CObject
    {
    public:

        AXP::ARESULT WriteToParcel(IN CONST AXP::Sp<AXP::CParcel> & parcel)
        {
            if (parcel == NULL)
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(AXP::String::Create(L"TestWorkModels.CVideoStreamingConfig"))))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mTestCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mVideoUrl)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mPlayTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mTimeOut)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mIntervalTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mPppType)))
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

            if (AXP::AFAILED(parcel->Read(mTestCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mVideoUrl)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mPlayTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mTimeOut)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mIntervalTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mPppType)))
                return AXP::AE_FAIL;

            return AXP::AS_OK;
        }

        AXP::Void Copy(IN CONST AXP::Sp<CVideoStreamingConfig> & obj)
        {
            if (obj == NULL)
                return;

            mTestCount = obj->mTestCount;
            mVideoUrl = obj->mVideoUrl;
            mPlayTime = obj->mPlayTime;
            mTimeOut = obj->mTimeOut;
            mIntervalTime = obj->mIntervalTime;
            mPppType = obj->mPppType;
        }

        AXP::Void SetNull()
        {
            mTestCount = 0;
            mVideoUrl = NULL;
            mPlayTime = 0;
            mTimeOut = 0;
            mIntervalTime = 0;
            mPppType = 0;
        }

        VIRTUAL AXP::Sp<AXP::String> ToString()
        {
            AXP::Sp<AXP::String> json = AXP::String::Create(L"{");
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mTestCount\":\"%d\",", (AXP::PCWStr)*json, mTestCount);
            if (json == NULL)
                return NULL;

            if (mVideoUrl == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mVideoUrl\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mVideoUrl->Length() + 40, L"%ls\"mVideoUrl\":\"%ls\",", (AXP::PCWStr)*json, (AXP::PCWStr)*mVideoUrl);
                if (json == NULL)
                    return NULL;
            }

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mPlayTime\":\"%d\",", (AXP::PCWStr)*json, mPlayTime);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mTimeOut\":\"%d\",", (AXP::PCWStr)*json, mTimeOut);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mIntervalTime\":\"%d\",", (AXP::PCWStr)*json, mIntervalTime);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mPppType\":\"%d\"", (AXP::PCWStr)*json, mPppType);
            if (json == NULL)
                return NULL;

            return AXP::String::Create(json->Length() + 7, L"%ls}", (AXP::PCWStr)*json);
        }

        VIRTUAL AXP::Sp<AXP::String> GetTypeName()
        {
            return AXP::String::Create(L"TestWorkModels.CVideoStreamingConfig");
        }

    public:

        STATIC AXP::Sp<AXP::CObject> Create()
        {
            return new CVideoStreamingConfig();
        }

    public:

        AXP::Int32 mTestCount;
        AXP::Sp<AXP::String> mVideoUrl;
        AXP::Int32 mPlayTime;
        AXP::Int32 mTimeOut;
        AXP::Int32 mIntervalTime;
        AXP::Int32 mPppType;
    };

    class CWAPDownloadConfig : public AXP::IParcelable, public AXP::CObject
    {
    public:

        AXP::ARESULT WriteToParcel(IN CONST AXP::Sp<AXP::CParcel> & parcel)
        {
            if (parcel == NULL)
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(AXP::String::Create(L"TestWorkModels.CWAPDownloadConfig"))))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mTestCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mUrl)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mTimeOut)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mIntervalTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mWAPProtocol)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mIsUseGateway)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mProxy)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mPort)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mPppType)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mThreadCount)))
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

            if (AXP::AFAILED(parcel->Read(mTestCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mUrl)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mTimeOut)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mIntervalTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mWAPProtocol)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mIsUseGateway)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mProxy)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mPort)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mPppType)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mThreadCount)))
                return AXP::AE_FAIL;

            return AXP::AS_OK;
        }

        AXP::Void Copy(IN CONST AXP::Sp<CWAPDownloadConfig> & obj)
        {
            if (obj == NULL)
                return;

            mTestCount = obj->mTestCount;
            mUrl = obj->mUrl;
            mTimeOut = obj->mTimeOut;
            mIntervalTime = obj->mIntervalTime;
            mWAPProtocol = obj->mWAPProtocol;
            mIsUseGateway = obj->mIsUseGateway;
            mProxy = obj->mProxy;
            mPort = obj->mPort;
            mPppType = obj->mPppType;
            mThreadCount = obj->mThreadCount;
        }

        AXP::Void SetNull()
        {
            mTestCount = 0;
            mUrl = NULL;
            mTimeOut = 0;
            mIntervalTime = 0;
            mWAPProtocol = 0;
            mIsUseGateway = 0;
            mProxy = NULL;
            mPort = 0;
            mPppType = 0;
            mThreadCount = 0;
        }

        VIRTUAL AXP::Sp<AXP::String> ToString()
        {
            AXP::Sp<AXP::String> json = AXP::String::Create(L"{");
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mTestCount\":\"%d\",", (AXP::PCWStr)*json, mTestCount);
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

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mTimeOut\":\"%d\",", (AXP::PCWStr)*json, mTimeOut);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mIntervalTime\":\"%d\",", (AXP::PCWStr)*json, mIntervalTime);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mWAPProtocol\":\"%d\",", (AXP::PCWStr)*json, mWAPProtocol);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mIsUseGateway\":\"%ls\",", (AXP::PCWStr)*json, mIsUseGateway ? L"true" : L"false");
            if (json == NULL)
                return NULL;

            if (mProxy == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mProxy\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mProxy->Length() + 40, L"%ls\"mProxy\":\"%ls\",", (AXP::PCWStr)*json, (AXP::PCWStr)*mProxy);
                if (json == NULL)
                    return NULL;
            }

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mPort\":\"%d\",", (AXP::PCWStr)*json, mPort);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mPppType\":\"%d\",", (AXP::PCWStr)*json, mPppType);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mThreadCount\":\"%d\"", (AXP::PCWStr)*json, mThreadCount);
            if (json == NULL)
                return NULL;

            return AXP::String::Create(json->Length() + 7, L"%ls}", (AXP::PCWStr)*json);
        }

        VIRTUAL AXP::Sp<AXP::String> GetTypeName()
        {
            return AXP::String::Create(L"TestWorkModels.CWAPDownloadConfig");
        }

    public:

        STATIC AXP::Sp<AXP::CObject> Create()
        {
            return new CWAPDownloadConfig();
        }

    public:

        AXP::Int32 mTestCount;
        AXP::Sp<AXP::String> mUrl;
        AXP::Int32 mTimeOut;
        AXP::Int32 mIntervalTime;
        AXP::Int32 mWAPProtocol;
        AXP::Boolean mIsUseGateway;
        AXP::Sp<AXP::String> mProxy;
        AXP::Int32 mPort;
        AXP::Int32 mPppType;
        AXP::Int32 mThreadCount;
    };

    class CWAPPageConfig : public AXP::IParcelable, public AXP::CObject
    {
    public:

        AXP::ARESULT WriteToParcel(IN CONST AXP::Sp<AXP::CParcel> & parcel)
        {
            if (parcel == NULL)
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(AXP::String::Create(L"TestWorkModels.CWAPPageConfig"))))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mTestCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mTestMode)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mPageUrl)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mTimeOut)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mWAPProtocol)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mIntervalTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mIsLoadImage)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mIsCleanCookie)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mIsUseGateway)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mProxy)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mPort)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mPppType)))
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

            if (AXP::AFAILED(parcel->Read(mTestCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mTestMode)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mPageUrl)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mTimeOut)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mWAPProtocol)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mIntervalTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mIsLoadImage)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mIsCleanCookie)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mIsUseGateway)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mProxy)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mPort)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mPppType)))
                return AXP::AE_FAIL;

            return AXP::AS_OK;
        }

        AXP::Void Copy(IN CONST AXP::Sp<CWAPPageConfig> & obj)
        {
            if (obj == NULL)
                return;

            mTestCount = obj->mTestCount;
            mTestMode = obj->mTestMode;
            mPageUrl = obj->mPageUrl;
            mTimeOut = obj->mTimeOut;
            mWAPProtocol = obj->mWAPProtocol;
            mIntervalTime = obj->mIntervalTime;
            mIsLoadImage = obj->mIsLoadImage;
            mIsCleanCookie = obj->mIsCleanCookie;
            mIsUseGateway = obj->mIsUseGateway;
            mProxy = obj->mProxy;
            mPort = obj->mPort;
            mPppType = obj->mPppType;
        }

        AXP::Void SetNull()
        {
            mTestCount = 0;
            mTestMode = 0;
            mPageUrl = NULL;
            mTimeOut = 0;
            mWAPProtocol = 0;
            mIntervalTime = 0;
            mIsLoadImage = 0;
            mIsCleanCookie = 0;
            mIsUseGateway = 0;
            mProxy = NULL;
            mPort = 0;
            mPppType = 0;
        }

        VIRTUAL AXP::Sp<AXP::String> ToString()
        {
            AXP::Sp<AXP::String> json = AXP::String::Create(L"{");
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mTestCount\":\"%d\",", (AXP::PCWStr)*json, mTestCount);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mTestMode\":\"%d\",", (AXP::PCWStr)*json, mTestMode);
            if (json == NULL)
                return NULL;

            if (mPageUrl == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mPageUrl\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mPageUrl->Length() + 40, L"%ls\"mPageUrl\":\"%ls\",", (AXP::PCWStr)*json, (AXP::PCWStr)*mPageUrl);
                if (json == NULL)
                    return NULL;
            }

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mTimeOut\":\"%d\",", (AXP::PCWStr)*json, mTimeOut);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mWAPProtocol\":\"%d\",", (AXP::PCWStr)*json, mWAPProtocol);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mIntervalTime\":\"%d\",", (AXP::PCWStr)*json, mIntervalTime);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mIsLoadImage\":\"%ls\",", (AXP::PCWStr)*json, mIsLoadImage ? L"true" : L"false");
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mIsCleanCookie\":\"%ls\",", (AXP::PCWStr)*json, mIsCleanCookie ? L"true" : L"false");
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mIsUseGateway\":\"%ls\",", (AXP::PCWStr)*json, mIsUseGateway ? L"true" : L"false");
            if (json == NULL)
                return NULL;

            if (mProxy == NULL) {
                json = AXP::String::Create(json->Length() + 40, L"%ls\"mProxy\":\"\",", (AXP::PCWStr)*json);
                if (json == NULL)
                    return NULL;
            }
            else {
                json = AXP::String::Create(json->Length() + mProxy->Length() + 40, L"%ls\"mProxy\":\"%ls\",", (AXP::PCWStr)*json, (AXP::PCWStr)*mProxy);
                if (json == NULL)
                    return NULL;
            }

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mPort\":\"%d\",", (AXP::PCWStr)*json, mPort);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mPppType\":\"%d\"", (AXP::PCWStr)*json, mPppType);
            if (json == NULL)
                return NULL;

            return AXP::String::Create(json->Length() + 7, L"%ls}", (AXP::PCWStr)*json);
        }

        VIRTUAL AXP::Sp<AXP::String> GetTypeName()
        {
            return AXP::String::Create(L"TestWorkModels.CWAPPageConfig");
        }

    public:

        STATIC AXP::Sp<AXP::CObject> Create()
        {
            return new CWAPPageConfig();
        }

    public:

        AXP::Int32 mTestCount;
        AXP::Int32 mTestMode;
        AXP::Sp<AXP::String> mPageUrl;
        AXP::Int32 mTimeOut;
        AXP::Int32 mWAPProtocol;
        AXP::Int32 mIntervalTime;
        AXP::Boolean mIsLoadImage;
        AXP::Boolean mIsCleanCookie;
        AXP::Boolean mIsUseGateway;
        AXP::Sp<AXP::String> mProxy;
        AXP::Int32 mPort;
        AXP::Int32 mPppType;
    };

    class CParallelTaskConfig : public AXP::IParcelable, public AXP::CObject
    {
    public:

        AXP::ARESULT WriteToParcel(IN CONST AXP::Sp<AXP::CParcel> & parcel)
        {
            if (parcel == NULL)
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(AXP::String::Create(L"TestWorkModels.CParallelTaskConfig"))))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mTestCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mIntervalTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mVoiceDelay)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Write(mPppType)))
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

            if (AXP::AFAILED(parcel->Read(mTestCount)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mIntervalTime)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mVoiceDelay)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(parcel->Read(mPppType)))
                return AXP::AE_FAIL;

            if (AXP::AFAILED(ObjectParcel::ReadListOfObjectFromParcel(parcel, mTaskItems)))
                return AXP::AE_FAIL;

            return AXP::AS_OK;
        }

        AXP::Void Copy(IN CONST AXP::Sp<CParallelTaskConfig> & obj)
        {
            if (obj == NULL)
                return;

            mTestCount = obj->mTestCount;
            mIntervalTime = obj->mIntervalTime;
            mVoiceDelay = obj->mVoiceDelay;
            mPppType = obj->mPppType;
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
            mTestCount = 0;
            mIntervalTime = 0;
            mVoiceDelay = 0;
            mPppType = 0;
            mTaskItems = NULL;
        }

        VIRTUAL AXP::Sp<AXP::String> ToString()
        {
            AXP::Sp<AXP::String> json = AXP::String::Create(L"{");
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mTestCount\":\"%d\",", (AXP::PCWStr)*json, mTestCount);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mIntervalTime\":\"%d\",", (AXP::PCWStr)*json, mIntervalTime);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mVoiceDelay\":\"%d\",", (AXP::PCWStr)*json, mVoiceDelay);
            if (json == NULL)
                return NULL;

            json = AXP::String::Create(json->Length() + 47, L"%ls\"mPppType\":\"%d\",", (AXP::PCWStr)*json, mPppType);
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
            return AXP::String::Create(L"TestWorkModels.CParallelTaskConfig");
        }

    public:

        STATIC AXP::Sp<AXP::CObject> Create()
        {
            return new CParallelTaskConfig();
        }

    public:

        AXP::Int32 mTestCount;
        AXP::Int32 mIntervalTime;
        AXP::Int32 mVoiceDelay;
        AXP::Int32 mPppType;
        AXP::Sp<AXP::List<CTestItem > > mTaskItems;
    };

    STATIC AXP::Boolean _TestWorkModels_CCallConfig_ = ObjectParcel::InsertMappingTable(L"TestWorkModels.CCallConfig", TestWorkModels::CCallConfig::Create);
    STATIC AXP::Boolean _TestWorkModels_CFtpDownloadConfig_ = ObjectParcel::InsertMappingTable(L"TestWorkModels.CFtpDownloadConfig", TestWorkModels::CFtpDownloadConfig::Create);
    STATIC AXP::Boolean _TestWorkModels_CFtpUploadConfig_ = ObjectParcel::InsertMappingTable(L"TestWorkModels.CFtpUploadConfig", TestWorkModels::CFtpUploadConfig::Create);
    STATIC AXP::Boolean _TestWorkModels_CHttpDownloadConfig_ = ObjectParcel::InsertMappingTable(L"TestWorkModels.CHttpDownloadConfig", TestWorkModels::CHttpDownloadConfig::Create);
    STATIC AXP::Boolean _TestWorkModels_CHttpPageConfig_ = ObjectParcel::InsertMappingTable(L"TestWorkModels.CHttpPageConfig", TestWorkModels::CHttpPageConfig::Create);
    STATIC AXP::Boolean _TestWorkModels_CHttpUploadConfig_ = ObjectParcel::InsertMappingTable(L"TestWorkModels.CHttpUploadConfig", TestWorkModels::CHttpUploadConfig::Create);
    STATIC AXP::Boolean _TestWorkModels_CIdleConfig_ = ObjectParcel::InsertMappingTable(L"TestWorkModels.CIdleConfig", TestWorkModels::CIdleConfig::Create);
    STATIC AXP::Boolean _TestWorkModels_CPingConfig_ = ObjectParcel::InsertMappingTable(L"TestWorkModels.CPingConfig", TestWorkModels::CPingConfig::Create);
    STATIC AXP::Boolean _TestWorkModels_CReceiveEmailConfig_ = ObjectParcel::InsertMappingTable(L"TestWorkModels.CReceiveEmailConfig", TestWorkModels::CReceiveEmailConfig::Create);
    STATIC AXP::Boolean _TestWorkModels_CSendEmailConfig_ = ObjectParcel::InsertMappingTable(L"TestWorkModels.CSendEmailConfig", TestWorkModels::CSendEmailConfig::Create);
    STATIC AXP::Boolean _TestWorkModels_CSmsReceiveConfig_ = ObjectParcel::InsertMappingTable(L"TestWorkModels.CSmsReceiveConfig", TestWorkModels::CSmsReceiveConfig::Create);
    STATIC AXP::Boolean _TestWorkModels_CSmsSendConfig_ = ObjectParcel::InsertMappingTable(L"TestWorkModels.CSmsSendConfig", TestWorkModels::CSmsSendConfig::Create);
    STATIC AXP::Boolean _TestWorkModels_CTraceRouteConfig_ = ObjectParcel::InsertMappingTable(L"TestWorkModels.CTraceRouteConfig", TestWorkModels::CTraceRouteConfig::Create);
    STATIC AXP::Boolean _TestWorkModels_CVideoStreamingConfig_ = ObjectParcel::InsertMappingTable(L"TestWorkModels.CVideoStreamingConfig", TestWorkModels::CVideoStreamingConfig::Create);
    STATIC AXP::Boolean _TestWorkModels_CWAPDownloadConfig_ = ObjectParcel::InsertMappingTable(L"TestWorkModels.CWAPDownloadConfig", TestWorkModels::CWAPDownloadConfig::Create);
    STATIC AXP::Boolean _TestWorkModels_CWAPPageConfig_ = ObjectParcel::InsertMappingTable(L"TestWorkModels.CWAPPageConfig", TestWorkModels::CWAPPageConfig::Create);
    STATIC AXP::Boolean _TestWorkModels_CParallelTaskConfig_ = ObjectParcel::InsertMappingTable(L"TestWorkModels.CParallelTaskConfig", TestWorkModels::CParallelTaskConfig::Create);
}
#endif // __CONFIGPARAM_H__