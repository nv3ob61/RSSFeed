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
package org.monmo.java.libraries;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author mon_mode
 */
public class UtilesEntrada {

  public static final Scanner SCN
          = new Scanner(System.in, "Windows-1252")
                  .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

  public static final String leerTexto(String msgUsr) {
    System.out.print(msgUsr);
    return SCN.nextLine();
  }

}
