/* 
 * Copyright (C) 2020 nv3ob61
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.monmo.java.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nv3ob61
 */
public class Feed {

  final String title;
  final String link;
  final String description;
  final String language;
  final String copyright;
  final String pubDate;

  final List<FeedMessage> entries = new ArrayList<>();

  public Feed(String title, String link, String description, String language,
          String copyright, String pubDate) {
    this.title = title;
    this.link = link;
    this.description = description;
    this.language = language;
    this.copyright = copyright;
    this.pubDate = pubDate;
  }

  public List<FeedMessage> getMessages() {
    return entries;
  }

  public String getTitle() {
    return title;
  }

  public String getLink() {
    return link;
  }

  public String getDescription() {
    return description;
  }

  public String getLanguage() {
    return language;
  }

  public String getCopyright() {
    return copyright;
  }

  public String getPubDate() {
    return pubDate;
  }

  @Override
  public String toString() {
    return String.format("FEED:%n"
            + "=====%n"
            + "COPYRIGHT: %s%n"
            + "DESCRIPTION: %s%n"
            + "LANGUAGE: %s%n"
            + "LINK: %s%n"
            + "PUB. DATE: %s%n"
            + "TITLE: %s%n",
            getCopyright(), getDescription(), getLanguage(),
            getLink(), getPubDate(), getTitle());
  }
}