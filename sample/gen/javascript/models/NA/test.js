
define(["core/parcel", "core/parcelable"], function ()
{
    $.declareClass("NA.CBase", XspWeb.Core.Parcelable, {
        ctor: function ()
        {
            this.mB = 0;
        },

        writeToParcel: function (parcel)
        {
            if (parcel == null)
                return;

            parcel.writeString("NA.CBase");
            parcel.writeByte(this.mB);
        },

        readFromParcel: function (parcel)
        {
            if (parcel == null)
                return;

            parcel.readString();
            this.mB = parcel.readByte();
        },

    });

    $.declareClass("NA.CList", NA.CBase, {
        ctor: function ()
        {
            this.parent();
            this.a = 0;
            this.c = 0;
            this.e = 0;
            this.bee = true;
            this.f = null;
            this.g = null;
            this.m = null;
            this.lstring = [];
            this.list64 = [];
            this.listDouble = [];
        },

        writeToParcel: function (parcel)
        {
            if (parcel == null)
                return;

            parcel.writeString("NA.CList");
            this.parent(parcel);
            parcel.writeInt8(this.a);
            parcel.writeInt64(this.c);
            parcel.writeDouble(this.e);
            parcel.writeBoolean(this.bee);
            parcel.writeNullableInt8(this.f);
            parcel.writeNullableInt64(this.g);
            parcel.writeString(this.m);
            if (this.lstring) {
                parcel.write("L", this.lstring.length);
                for (var i = 0; i < this.lstring.length; i++) {
                    if (this.lstring[i])
                        parcel.writeString(this.lstring[i]);
                }
            }
            else
                parcel.write("L", 0);

            if (this.list64) {
                parcel.write("L", this.list64.length);
                for (var i = 0; i < this.list64.length; i++) {
                    if (this.list64[i])
                        parcel.writeNullableInt64(this.list64[i]);
                }
            }
            else
                parcel.write("L", 0);

            if (this.listDouble) {
                parcel.write("L", this.listDouble.length);
                for (var i = 0; i < this.listDouble.length; i++) {
                    if (this.listDouble[i])
                        parcel.writeNullableDouble(this.listDouble[i]);
                }
            }
            else
                parcel.write("L", 0);

        },

        readFromParcel: function (parcel)
        {
            if (parcel == null)
                return;

            parcel.readString();
            this.parent(parcel);
            this.a = parcel.readInt8();
            this.c = parcel.readInt64();
            this.e = parcel.readDouble();
            this.bee = parcel.readBoolean();
            this.f = parcel.readNullableInt8();
            this.g = parcel.readNullableInt64();
            this.m = parcel.readString();
            var list = [];
            var length = parcel.read();
            for (var i = 0; i < length; i++) {
                var obj = parcel.readString();
                list.push(obj);
            }

            this.lstring = list;
            var list = [];
            var length = parcel.read();
            for (var i = 0; i < length; i++) {
                var obj = parcel.readNullableInt64();
                list.push(obj);
            }

            this.list64 = list;
            var list = [];
            var length = parcel.read();
            for (var i = 0; i < length; i++) {
                var obj = parcel.readNullableDouble();
                list.push(obj);
            }

            this.listDouble = list;
        },

    });
});
