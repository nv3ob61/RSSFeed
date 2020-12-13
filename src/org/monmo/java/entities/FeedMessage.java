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

/**
 *
 * @author nv3ob61
 */
public class FeedMessage {

  String title;
  String description;
  String link;
  String author;
  String guid;

  public FeedMessage() {
  }

  public FeedMessage(String title, String description, String link, String author, String guid) {
    this.title = title;
    this.description = description;
    this.link = link;
    this.author = author;
    this.guid = guid;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getGuid() {
    return guid;
  }

  public void setGuid(String guid) {
    this.guid = guid;
  }

  @Override
  public final String toString() {
    return String.format("FEED INFO:%n"
            + "==========%n"
            + "TITLE: %s%n"
            + "DESCRIPTION: %s%n"
            + "LINK: %s%n"
            + "AUTHOR: %s%n"
            + "GUID: %s%n",
            getTitle(), getDescription(), getLink(),
            getAuthor(), getGuid());
  }
  
  public final void muestraFeedMessage(){
    System.out.println(toString());
  }
}