
define(["core/parcel", "core/list", "IPC/javascript/IpcException", "IPC/javascript/CommandCode", "IPC/javascript/ObjectManager", "IPC/gen/javascript/service/TestB/TestB"], function ()
{
    $.declareClass("TestB.BObjectHolder", IPC.CObjectHolder, {
        static: {
            B_DESCRIPTOR: "TestB.B",
            B_Bar: 0,
            B_B: 1,
        },

        onTransact: function(parcel, isRemote)
        {
            if (parcel == null)
                return null;

            var funCode = parcel.readInt32();
            if (funCode == TestB.BObjectHolder.B_B) {
                if (this.mService == null) {
                    this.mService = TestB._B.Create();
                    if (this.mService == null)
                        return null;
                }

                if (!isRemote) {
                    if (!IPC.ObjectManager.registerObject(this.getHashCode(), this.mService))
                        return null;
                }

                parcel = new XspWeb.Core.Parcel();
                if (parcel == null)
                    return null;

                parcel.writeInt32(IPC.IpcException.NoException);
                parcel.writeInt64(this.getHashCode());
            }
            else {
                if (this.mService == null) {
                    parcel = new XspWeb.Core.Parcel();
                    if (parcel == null)
                        return null;

                    parcel.writeInt32(IPC.IpcException.RemoteRefException);
                    return parcel;
                }

                if (funCode == TestB.BObjectHolder.B_Bar) {
                    var a = parcel.readInt32();
                    var ret = this.mService.Bar(a);
                    parcel = new XspWeb.Core.Parcel();
                    if (parcel == null)
                        return null;

                    parcel.writeInt32(IPC.IpcException.NoException);
                    parcel.writeInt32(ret);
                }
            }

            return parcel;
        }

    });
});
