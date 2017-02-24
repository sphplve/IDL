
package TestWorkModels;

import AXP.IParcelable;
import AXP.CParcel;
import AXP.AResult;

public class CConfigParam implements IParcelable
{

    public int WriteToParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        if (AResult.AFAILED(parcel.WriteString("TestWorkModels.CConfigParam")))
            return AResult.AE_FAIL;

        return AResult.AS_OK;
    }

    public int ReadFromParcel(CParcel parcel)
    {
        if (parcel == null)
            return AResult.AE_FAIL;

        try {
            parcel.ReadString();
        }
        catch (Exception e) {
            return AResult.AE_FAIL;
        }

        return AResult.AS_OK;
    }

    public Boolean Copy(CConfigParam info)
    {
        if (info == null)
            return false;


        return true;
    }

    public void SetNull()
    {
    }

    public String ToString()
    {
        return String.format("");
    }
    
    public String GetTypeName() 
    {
            return "TestWorkModels.CConfigParam";
    }   
}
