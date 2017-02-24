
package Models;

import AXP.CParcel;
import AXP.AResult;

public class CLTEQOffsetCell extends CRadioMeasParam
{
    public Integer mQOffsetCell;

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("Models.CLTEQOffsetCell")))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(super.WriteToParcel(parcel)))
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteUInt16$(mQOffsetCell)))
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

            mQOffsetCell = parcel.ReadUInt16$();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CLTEQOffsetCell info)
    {
        if (info == null)
            return false;

        super.Copy(info);

        mQOffsetCell = info.mQOffsetCell;

        return true;
    }

    public void SetNull()
    {
        super.SetNull();

        mQOffsetCell = null;
    }

    public String ToString()
    {
        if (mQOffsetCell == null)
            return "";
        else
            return String.format("%s", mQOffsetCell);
    }

    public String GetTypeName()
    {
        return "Models.CLTEQOffsetCell";
    }
}
