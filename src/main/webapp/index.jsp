    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>LAB2: CHESNOKOV P32111</title>
        <link href = "css/stylesheets/index.css" rel="stylesheet" type="text/css">
    </head>

    <style>
        body {
            font-family: Futura Family, serif;
            background-size: cover;
            background-image: url("css/multimedia/riverwood-background.webp");
        }

        .container-input {
            font-size: large;

            margin: 20px;
        }

        @font-face {
            font-family: Futura Family;
            font-weight: normal;

            src: url("css/fonts/futurabookc.woff2") format("woff");
        }

    </style>
<%--FIXME: просит установить все флажки--%>
    <body>
        <header class="header-block">
            <img class = "avatar" src = "css/multimedia/skyrim-avatar.jpg" alt = "avatar">
            <span class = "header-info">
                Student: Chesnokov Arkady <br>
                Group: P32111             <br>
                Variant: 91356
            </span>
        </header>
        <div class="container">
            <div class="container-header">
                Enter point coordinates
            </div>
            <div class="container-input">
                <form id="input-coordinates" method="get" action="<%= request.getContextPath() %>/controller-servlet">
                    <fieldset>
                        <legend> Select 'X' </legend>
                        <input type="radio" id="x1" name="xCoord" value="-5" required>
                        <label for="x1">-5</label>

                        <input type="radio" id="x2" name="xCoord" value="-4" required>
                        <label for="x2">-4</label>

                        <input type="radio" id="x3" name="xCoord" value="-3" required>
                        <label for="x3">-3</label>

                        <input type="radio" id="x4" name="xCoord" value="-2" required>
                        <label for="x4">-2</label>

                        <input type="radio" id="x5" name="xCoord" value="-1" required>
                        <label for="x5">-1</label>

                        <input type="radio" id="x6" name="xCoord" value="0" required>
                        <label for="x6">0</label>

                        <input type="radio" id="x7" name="xCoord" value="1" required>
                        <label for="x7">1</label>

                        <input type="radio" id="x8" name="xCoord" value="2" required>
                        <label for="x8">2</label>

                        <input type="radio" id="x9" name="xCoord" value="3" required>
                        <label for="x9">3</label>
                    </fieldset>

                    <fieldset>
                        <legend> Select 'R' </legend>
                        <input type="checkbox" id="r1" name="rCoord" class="radius-checkbox" value="1">
                        <label for="r1">1</label>

                        <input type="checkbox" id="r1.5" name="rCoord" class="radius-checkbox" value="1.5">
                        <label for="r1.5">1.5</label>

                        <input type="checkbox" id="r2" name="rCoord" class="radius-checkbox" value="2">
                        <label for="r2">2</label>

                        <input type="checkbox" id="r2.5" name="rCoord" class="radius-checkbox" value="2.5">
                        <label for="r2.5">2.5</label>

                        <input type="checkbox" id="r3" name="rCoord" class="radius-checkbox" value="3">
                        <label for="r3">3</label>
                    </fieldset>

                    <fieldset>
                        <legend> Type 'Y' </legend>
<%--                        а так можно?--%>
                        <input type="text" id="yCoord" name="yCoord" required>
                        <label for="yCoord"></label>
                    </fieldset>

                    <fieldset>
                        <button type="submit"> Fus Ro Dah! </button>
                        <button type="reset"> Krii Lun Aus! </button>
                    </fieldset>

                </form>

                <div class = "container-coord">
                    <img class="coordinate-plane" src="css/multimedia/coord-plane.png" alt="coordinate plane">
<%--                   TODO: Книга разрушения - выпадающее меню - туда результаты попадания --%>
                </div>
            </div>


        </div>
    </body>
    <script defer src="scripts/jquery-3.6.3.js"></script>
    <script defer src="scripts/validator.js"></script>
    </html>