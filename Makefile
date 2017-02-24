all: IDLC

CFLAGS= \
	-DPLATFORM_LINUX \
	-DCOMPILER_GCC \
	-DARCH_X86 \
	-DARCH_LITTLE_ENDIAN
	
SRC= \
	AXP/xplatform/src/astring.cpp \
	AXP/xplatform/src/atime.cpp \
	AXP/xplatform/src/atom.cpp \
	AXP/xplatform/src/event.cpp \
	AXP/xplatform/src/mutex.cpp \
	AXP/xplatform/src/thread.cpp \
	AXP/xplatform/src/Parcel.cpp \
	AXP/libc/src/Common/BaseWorker.cpp \
	AXP/libc/src/Common/Tracker.cpp \
	AXP/libc/src/Network/HttpServer.cpp \
	AXP/ThirdParty/IConv/Libiconv/iconv.c \
	AXP/ThirdParty/IConv/Libiconv/localcharset.c \
	Common.cpp \
	IDLCWriteSourceFile_cpp.cpp \
	IDLCWriteSourceFile_cs.cpp \
	IDLCWriteSourceFile_objc.cpp \
	IDLCWriteSourceFile_java.cpp \
	IDLCWriteSourceFile_javascript.cpp \
	IDLCParser.cpp \
	SymbolRef.cpp \
	IDL.tab.cpp \
	IDL.cpp \
	GenerateIDL.cpp
	
IDLC: IDL.l IDL.y
	bison --defines=IDL.tab.hpp --output=IDL.tab.cpp IDL.y
	flex --outfile=IDL.cpp IDL.l
	g++ -g $(CFLAGS) -o GenerateIDL $(SRC) -lfl 

clean:
	rm IDL.tab.hpp IDL.tab.cpp IDL.cpp GenerateIDL.exe 
