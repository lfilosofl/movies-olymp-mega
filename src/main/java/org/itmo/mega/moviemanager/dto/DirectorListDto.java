package org.itmo.mega.moviemanager.dto;

import org.itmo.mega.moviemanager.model.Director;

import java.util.List;

public class DirectorListDto {

    private List<Director> list;

    public DirectorListDto() {
    }

    public DirectorListDto(List<Director> list) {
        this.list = list;
    }

    public List<Director> getList() {
        return list;
    }

    public void setList(List<Director> list) {
        this.list = list;
    }
}
