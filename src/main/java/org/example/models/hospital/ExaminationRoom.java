package org.example.models.hospital;

public class ExaminationRooms {

    private int examinationRoomNo;
    private String roomType;

    public ExaminationRooms() {
    }

    public ExaminationRooms(int examinationRoomNo, String roomType) {
        this.examinationRoomNo = examinationRoomNo;
        this.roomType = roomType;
    }

    public int getExaminationRoomNo() {
        return examinationRoomNo;
    }

    public void setExaminationRoomNo(int examinationRoomNo) {
        this.examinationRoomNo = examinationRoomNo;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return "ExaminationRooms{" +
                "examinationRoomNo=" + examinationRoomNo +
                ", roomType='" + roomType + '\'' +
                '}';
    }
}
