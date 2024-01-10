package org.example.models.hospital;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "examinationRoom")
@XmlType(propOrder = {"examinationRoomNo", "roomType"})
public class ExaminationRoom {

    private int examinationRoomNo;
    private String roomType;

    public ExaminationRoom() {
    }

    public ExaminationRoom(int examinationRoomNo, String roomType) {
        this.examinationRoomNo = examinationRoomNo;
        this.roomType = roomType;
    }

    public int getExaminationRoomNo() {
        return examinationRoomNo;
    }

    @XmlAttribute(name = "examinationRoomNo")
    public void setExaminationRoomNo(int examinationRoomNo) {
        this.examinationRoomNo = examinationRoomNo;
    }

    public String getRoomType() {
        return roomType;
    }

    @XmlElement(name = "roomType")
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return "ExaminationRoom{" +
                "examinationRoomNo=" + examinationRoomNo +
                ", roomType='" + roomType + '\'' +
                '}';
    }
}
