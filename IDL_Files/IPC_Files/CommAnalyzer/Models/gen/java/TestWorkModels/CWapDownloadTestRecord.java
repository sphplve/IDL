
package TestWorkModels;

import AXP.CParcel;
import AXP.AResult;

public class CWapDownloadTestRecord extends CTestRecord
{
    public double mSpeedAvg;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("TestWorkModels.CWapDownloadTestRecord")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteDouble(mSpeedAvg)))
            return AResult.AE_FAIL;

        return AResult.AS_OK;
    }

    public int ReadFromParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        try {
            parcel.ReadString();
            if (AResult.AFAILED(super.ReadFromParcel(parcel)))
                return AResult.AE_FAIL;

            mSpeedAvg = parcel.ReadDouble();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CWapDownloadTestRecord info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mSpeedAvg = info.mSpeedAvg;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mSpeedAvg = 0;
    }

    public String ToString()
    {
        return String.format("%s", mSpeedAvg);
    }

    public String GetTypeName()
    {
        return "TestWorkModels.CWapDownloadTestRecord";
    }
}
