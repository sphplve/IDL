
#ifndef __COMMON_H__
#define __COMMON_H__

#include "AXP/xplatform/include/stl/tree.h"
#include "IDLCSymbol.h"

namespace IDLC
{
    AXP::Sp<AXP::String> GetConsOrFuncId(IN AXP::STL::TreeNode<CSymbol> * node);
    AXP::Sp<AXP::String> GetDefConsId(IN AXP::STL::TreeNode<CSymbol> * node);
    AXP::Sp<AXP::String> GetDESCRIPTORId(IN AXP::STL::TreeNode<CSymbol> * node);
    FILE* OpenFile(IN CONST AXP::Sp<AXP::String> & fullFileName);
    AXP::Void GenerateDirPath(IN CONST AXP::Sp<AXP::String> & dirPath);
    AXP::Void FormatFile(IN CONST AXP::Sp<AXP::String> & fileName, IN enum _IDLFlag language);
    AXP::Int32 GetMode(IN AXP::STL::TreeNode<CSymbol> * node);
    AXP::Sp<CSymbol> GetVarSymbol(IN AXP::STL::TreeNode<CSymbol> * node);
    AXP::Sp<AXP::String> GetVarType(IN AXP::STL::TreeNode<CSymbol> * node, IN AXP::Int32 flag);
    AXP::Sp<AXP::String> GetVarType(IN AXP::STL::TreeNode<CSymbol> * node, IN enum _IDLFlag language, IN AXP::Int32 modeFlag);
    AXP::Sp<AXP::String> GetVarId(IN AXP::STL::TreeNode<CSymbol> * node);
    AXP::Sp<AXP::String> GetNameSpace(IN AXP::STL::TreeNode<CSymbol> * node);
    AXP::Sp<AXP::String> GetTypeReferenceList(IN AXP::STL::TreeNode<CSymbol> * node, IN enum _IDLFlag language);
    AXP::Sp<AXP::String> GetParameter(IN AXP::STL::TreeNode<CSymbol> * node, IN enum _IDLFlag language);
    AXP::Sp<AXP::String> GetFormParameters(IN AXP::STL::TreeNode<CSymbol> * node, IN enum _IDLFlag language);
    AXP::Sp<AXP::String> GetScopeChainOfClassName(IN AXP::STL::TreeNode<CSymbol> * node, IN enum _IDLFlag language);
    AXP::STL::TreeNode<CSymbol> * GetTypeReferenceTreeNode(IN AXP::STL::TreeNode<CSymbol> * node);
    AXP::ARESULT IsComplexMember(IN AXP::STL::TreeNode<CSymbol> * node, OUT AXP::Boolean & isComplex);
    AXP::Boolean HasObjectTypeInInterface(IN AXP::STL::TreeNode<CSymbol> * node);

    class CMappingInfo : public AXP::CObject
    {
    public:

        AXP::Sp<AXP::String> mDescription;
        AXP::Sp<AXP::String> mScope;
    };

    class CMappingArea
    {
    public:

        AXP::WChar mDescription[256];
        AXP::WChar mScope[256];
    };
}


#endif // __COMMON_H__