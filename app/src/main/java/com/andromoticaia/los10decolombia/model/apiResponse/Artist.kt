package com.andromoticaia.los10decolombia.model.apiResponse

import android.os.Parcel
import android.os.Parcelable

data class Artist(
    val name: String? = null,
    val listeners: String? = null,
    val mbid: String? = null,
    val url: String? = null,
    val streamable: String? = null,
    val image: List<Image>? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createTypedArrayList(Image) as List<Image>
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(listeners)
        parcel.writeString(mbid)
        parcel.writeString(url)
        parcel.writeString(streamable)
        parcel.writeTypedList(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Artist> {
        override fun createFromParcel(parcel: Parcel): Artist {
            return Artist(parcel)
        }

        override fun newArray(size: Int): Array<Artist?> {
            return arrayOfNulls(size)
        }
    }
}