
define(["core/parcel", "core/list", "IPC/javascript/IpcException", "IPC/javascript/CommandCode", "IPC/javascript/ObjectManager", "IPC/gen/javascript/service/TestA/TestA"], function ()
{
    $.declareClass("TestA.AObjectHolder", IPC.CObjectHolder, {
        static: {
            A_DESCRIPTOR: "TestA.A",
            A_Foo: 0,
            A_SetListener: 1,
            A_A: 2,
        },

        onTransact: function(parcel, isRemote)
        {
            if (parcel == null)
                return null;

            var funCode = parcel.readInt32();
            if (funCode == TestA.AObjectHolder.A_A) {
                if (this.mService == null) {
                    this.mService = TestA._A.Create();
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

                if (funCode == TestA.AObjectHolder.A_Foo) {
                    var a = parcel.readInt32();
                    var hasValue = parcel.readBooelan();
                    if (hasValue) {
                        var clazz = eval(parcel.get(parcel.getPosition()));
                        if (!clazz)
                            return;

                        var b = new clazz;
                        b.readFromParcel(parcel);
                    }
                    else
                        var b = null;

                    var ret = this.mService.Foo(a, b);
                    parcel = new XspWeb.Core.Parcel();
                    if (parcel == null)
                        return null;

                    parcel.writeInt32(IPC.IpcException.NoException);
                    parcel.writeInt32(ret);
                }
                else if (funCode == TestA.AObjectHolder.A_SetListener) {
                    var bb = parcel.readInt64();
                    var bb = TestB.B.Create(bb);
                    this.mService.SetListener(bb);
                    parcel = new XspWeb.Core.Parcel();
                    if (parcel == null)
                        return null;

                    parcel.writeInt32(IPC.IpcException.NoException);
                }
            }

            return parcel;
        }

    });
});
