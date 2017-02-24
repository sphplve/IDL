
define(["core/parcel", "core/list", "core/hashTable", "IPC/javascript/Stub", "IPC/javascript/IpcException", "IPC/javascript/CommandCode", "IPC/gen/javascript/stub/TestA/TestAObjectHolder"], function ()
{
    $.declareClass("TestA.AStub", IPC.IStub, {
        ctor: function ()
        {
            this.mServiceList = new XspWeb.Core.HashTable();
            if (this.mServiceList == null)
                return null;
        },

        transact: function(bundle)
        {
            if (bundle == null)
                return null;

            var code = bundle.readInt32();
            if (code == IPC.CommandCode.commandCreate) {
                var isRemote = bundle.readBoolean();
                if (isRemote)
                    var uri = bundle.readString();

                var obj = new TestA.AObjectHolder();
                if (obj == null)
                    return null;

                this.mServiceList.add(obj.getHashCode(), obj);
                return obj.onTransact(bundle, isRemote);
            }
            else if (IPC.CommandCode.commandCall) {
                var objRef = bundle.readInt64();
                var obj = this.mServiceList.get(objRef);
                if (obj == null) {
                    parcel.writeInt32(IPC.IpcException.RemoteRefException)
                    return parcel;
                }

                return obj.onTransact(bundle, isRemote);
            }
            else
                return null;
        }
    });
});
