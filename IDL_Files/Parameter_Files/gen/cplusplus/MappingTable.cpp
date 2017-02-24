
#include "Models/StatisticsInfo.h"
#include "Models/TestInfo.h"

AXP::Boolean InitMappingTable()
{
    if (!ObjectParcel::InsertMappingTable(L"Models.CStatisticsInfo", Models::CStatisticsInfo::Create))
        return FALSE;

    if (!ObjectParcel::InsertMappingTable(L"Models.CTestInfo", Models::CTestInfo::Create))
        return FALSE;

    return TRUE;
}

AXP::Boolean __sClassMappingTable__ = InitMappingTable();
