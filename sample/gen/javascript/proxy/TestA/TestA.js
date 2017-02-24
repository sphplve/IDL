
define(["core/parcel", "core/list", "IPC/javascript/IpcException", "IPC/javascript/ServerConnection", "IPC/javascript/CommandCode", "IPC/javascript/ServiceManager", "IPC/gen/javascript/include/TestA/ITestA"], function ()
{
    $.declareClass("TestA.A", TestA.IA, {
        static: {
            A_DESCRIPTOR: "TestA.A",
            A_Foo: 0,
            A_SetListener: 1,
            A_A: 2,
            Create: function()
            {
                return new TestA.A();
            }
        },

        ctor: function ()
        {
            this.mInterface = null;
            var parcel = new XspWeb.Core.Parcel();
            if (parcel == null)
                return;

            var stub = IPC.ServiceManager.getService(TestA.A.A_DESCRIPTOR);
            if (stub == null) {
                this.mIsRemote = true;
                this.mConn = IPC.CServerConnection.create(TestA.A.A_DESCRIPTOR);
                if (this.mConn == null)
                    return null;

                parcel.writeInt8(0xB3);
                if (typeof IPC.token == "undefined")
                    return null;

                parcel.writeString(IPC.token);
                parcel.writeString(TestA.A.A_DESCRIPTOR);
            }
            else {
                this.mIsRemote = false;
                this.mConn = stub;
            }

            parcel.writeInt32(IPC.CommandCode.commandCreate);
            parcel.writeBoolean(this.mIsRemote);
            if (this.mIsRemote)
                parcel.writeString(IPC.ServiceManager.sServiceManagerAddr);

            parcel.writeInt32(TestA.A.A_A);
            parcel.reset();
            parcel = this.mConn.transact(parcel);
            parcel.reset();
            var code = parcel.readInt32();
            IPC.IpcException.readException(code);
            this.mRef = parcel.readInt64();
            if (!this.mIsRemote)
                this.mInterface = IPC.ObjectManager.getValue(this.mRef);
        },

        Foo: function (a, b)
        {
            if (this.mIsRemote) {
                var parcel = new XspWeb.Core.Parcel();
                parcel.writeInt8(0xB3);
                parcel.writeString(IPC.token);
                parcel.writeString(TestA.A.A_DESCRIPTOR);
                parcel.writeInt32(IPC.CommandCode.commandCall);
                parcel.writeInt64(this.mRef);
                parcel.writeInt32(TestA.A.A_Foo);
                parcel.writeInt32(a);
                if (b) {
                    parcel.writeBoolean(true);
                    b.writeToParcel(parcel);
                }
                else
                    parcel.writeBoolean(false);

                parcel.reset();
                parcel = this.mConn.transact(parcel);
                parcel.reset();
                var code = parcel.readInt32();
                IPC.IpcException.readException(code);
                var ret = parcel.readInt32();
                return ret;
            }
            else {
                return this.mInterface.Foo(a, b);
            }
        },

        SetListener: function (bb)
        {
            if (this.mIsRemote) {
                var parcel = new XspWeb.Core.Parcel();
                parcel.writeInt8(0xB3);
                parcel.writeString(IPC.token);
                parcel.writeString(TestA.A.A_DESCRIPTOR);
                parcel.writeInt32(IPC.CommandCode.commandCall);
                parcel.writeInt64(this.mRef);
                parcel.writeInt32(TestA.A.A_SetListener);
                parcel.writeInt64(bb.GetRemoteRef());
                parcel.reset();
                parcel = this.mConn.transact(parcel);
                parcel.reset();
                var code = parcel.readInt32();
                IPC.IpcException.readException(code);
                return;
            }
            else {
                this.mInterface.SetListener(bb);
                return;
            }
        },

        GetRemoteRef: function()
        {
            return this.mRef;
        },

        GetInterface: function()
        {
            return this.mInterface;
        }
    });
});
