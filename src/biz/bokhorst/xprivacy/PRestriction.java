package biz.bokhorst.xprivacy;

import android.os.Parcel;
import android.os.Parcelable;

public class PRestriction implements Parcelable {
	public int uid;
	public String restrictionName;
	public String methodName;
	public String extra;
	public boolean restricted;
	public boolean asked;
	public long time;

	public PRestriction() {
	}

	public PRestriction(PRestriction other) {
		uid = other.uid;
		restrictionName = other.restrictionName;
		methodName = other.methodName;
		extra = null;
		restricted = other.restricted;
		asked = other.asked;
		time = other.time;
	}

	public PRestriction(int _uid, String category, String method) {
		uid = _uid;
		restrictionName = category;
		methodName = method;
		extra = null;
		restricted = false;
		asked = false;
		time = 0;
	}

	public PRestriction(int _uid, String category, String method, boolean _restricted) {
		uid = _uid;
		restrictionName = category;
		methodName = method;
		extra = null;
		restricted = _restricted;
		asked = false;
		time = 0;
	}

	public PRestriction(int _uid, String category, String method, boolean _restricted, boolean _asked) {
		uid = _uid;
		restrictionName = category;
		methodName = method;
		extra = null;
		restricted = _restricted;
		asked = _asked;
		time = 0;
	}

	public static final Parcelable.Creator<PRestriction> CREATOR = new Parcelable.Creator<PRestriction>() {
		public PRestriction createFromParcel(Parcel in) {
			return new PRestriction(in);
		}

		public PRestriction[] newArray(int size) {
			return new PRestriction[size];
		}
	};

	private PRestriction(Parcel in) {
		readFromParcel(in);
	}

	@Override
	public void writeToParcel(Parcel out, int flags) {
		out.writeInt(uid);
		out.writeString(restrictionName);
		out.writeInt(methodName == null ? 1 : 0);
		if (methodName != null)
			out.writeString(methodName);
		out.writeInt(extra == null ? 1 : 0);
		if (extra != null)
			out.writeString(extra);
		out.writeInt(restricted ? 1 : 0);
		out.writeInt(asked ? 1 : 0);
		out.writeLong(time);
	}

	public void readFromParcel(Parcel in) {
		uid = in.readInt();
		restrictionName = in.readString();
		if (in.readInt() > 0)
			methodName = null;
		else
			methodName = in.readString();
		if (in.readInt() > 0)
			extra = null;
		else
			extra = in.readString();
		restricted = (in.readInt() > 0 ? true : false);
		asked = (in.readInt() > 0 ? true : false);
		time = in.readLong();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public String toString() {
		return "uid=" + uid + " " + restrictionName + "/" + methodName + "=" + restricted + (asked ? "!" : "?");
	}
}
