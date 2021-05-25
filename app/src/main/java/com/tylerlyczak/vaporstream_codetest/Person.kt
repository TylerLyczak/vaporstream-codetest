package com.tylerlyczak.vaporstream_codetest

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Person Class
 *  Defines a structure for the room database for the storage the app uses
 */
@Entity(tableName = "person_table")
class Person (
    @ColumnInfo(name = "first_name") val firstName: String,
    @ColumnInfo(name = "last_name") val lastName: String,
    @ColumnInfo(name = "phone_number") val phoneNumber: String,
    @ColumnInfo(name = "address_1") val address1: String,
    @ColumnInfo(name = "address_2") val address2: String,
    @ColumnInfo(name = "city_name") val cityName: String,
    @ColumnInfo(name = "state_name") val stateName: String,
    @ColumnInfo(name = "zip_code") val zipCode: String
) {
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}