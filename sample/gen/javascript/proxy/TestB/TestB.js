
define(["core/parcel", "core/list", "IPC/javascript/IpcException", "IPC/javascript/ServerConnection", "IPC/javascript/CommandCode", "IPC/javascript/ServiceManager", "IPC/gen/javascript/include/TestB/ITestB"], function ()
{
    $.declareClass("TestB.B", TestB.IB, {
        static: {
            B_DESCRIPTOR: "TestB.B",
            B_Bar: 0,
            B_B: 1,
            Create: function()
            {
                return new TestB.B();
            }
        },

        ctor: function ()
        {
            this.mInterface = null;
            var parcel = new XspWeb.Core.Parcel();
            if (parcel == null)
                return;

            var stub = IPC.ServiceManager.getService(TestB.B.B_DESCRIPTOR);
            if (stub == null) {
                this.mIsRemote = true;
                this.mConn = IPC.CServerConnection.create(TestB.B.B_DESCRIPTOR);
                if (this.mConn == null)
                    return null;

                parcel.writeInt8(0xB3);
                if (typeof IPC.token == "undefined")
                    return null;

                parcel.writeString(IPC.token);
                parcel.writeString(TestB.B.B_DESCRIPTOR);
            }
            else {
                this.mIsRemote = false;
                this.mConn = stub;
            }

            parcel.writeInt32(IPC.CommandCode.commandCreate);
            parcel.writeBoolean(this.mIsRemote);
            if (this.mIsRemote)
                parcel.writeString(IPC.ServiceManager.sServiceManagerAddr);

            parcel.writeInt32(TestB.B.B_B);
            parcel.reset();
            parcel = this.mConn.transact(parcel);
            parcel.reset();
            var code = parcel.readInt32();
            IPC.IpcException.readException(code);
            this.mRef = parcel.readInt64();
            if (!this.mIsRemote)
                this.mInterface = IPC.ObjectManager.getValue(this.mRef);
        },

        Bar: function (a)
        {
            if (this.mIsRemote) {
                var parcel = new XspWeb.Core.Parcel();
                parcel.writeInt8(0xB3);
                parcel.writeString(IPC.token);
                parcel.writeString(TestB.B.B_DESCRIPTOR);
                parcel.writeInt32(IPC.CommandCode.commandCall);
                parcel.writeInt64(this.mRef);
                parcel.writeInt32(TestB.B.B_Bar);
                parcel.writeInt32(a);
                parcel.reset();
                parcel = this.mConn.transact(parcel);
                parcel.reset();
                var code = parcel.readInt32();
                IPC.IpcException.readException(code);
                var ret = parcel.readInt32();
                return ret;
            }
            else {
                return this.mInterface.Bar(a);
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
