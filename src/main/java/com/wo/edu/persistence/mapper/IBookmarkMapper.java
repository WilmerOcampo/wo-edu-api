package com.wo.edu.persistence.mapper;

import com.wo.edu.domain.dto.BookmarkDto;
import com.wo.edu.persistence.entity.user.Bookmark;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IBookmarkMapper {
    @Mapping(target = "userId", ignore = true)
    BookmarkDto toBookmarkDto(Bookmark bookmark);

    List<BookmarkDto> toBookmarksDto(List<Bookmark> bookmarks);

    @InheritInverseConfiguration
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "user", ignore = true)
    Bookmark toBookmark(BookmarkDto bookmarkDto);
}
