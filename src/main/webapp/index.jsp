    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>LAB2: CHESNOKOV P32111</title>
        <link href = "css/style.css" rel="stylesheet" type="text/css">
    </head>
    <style>
        /*FIXME*/
        body {
            background-image: url("css/images/riverwood-background.webp");
        }

        fieldset {
            border: 0;
        }

        @font-face {
            font-family: Futura Family;
            font-weight: normal;

            src: url("css/fonts/futurabookc.woff2") format("woff");
        }

        .container-input {
            font-size: large;

            margin: 20px;
        }
    </style>
    <body>
        <header class="header-block">
            <img class = "avatar" src = "css/images/skyrim-avatar.jpg" alt = "avatar">
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
                <form name="input-coordinates" method="get" action="validator.js">
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
                        <input type="checkbox" id="r1" name="rCoord" value="1" required>
                        <label for="r1">1</label>

                        <input type="checkbox" id="r1.5" name="rCoord" value="1.5" required>
                        <label for="r1.5">1.5</label>

                        <input type="checkbox" id="r2" name="rCoord" value="2" required>
                        <label for="r2">2</label>

                        <input type="checkbox" id="r2.5" name="rCoord" value="2.5" required>
                        <label for="r2.5">2.5</label>

                        <input type="checkbox" id="r3" name="rCoord" value="3" required>
                        <label for="r3">3</label>
                    </fieldset>

                    <fieldset>
                        <legend> Type 'Y' </legend>
                        <input type="text" id="yCoord" required>
                        <label for="yCoord"></label>
                    </fieldset>

                    <fieldset>
                        <button type="submit"> Fus Ro Dah! </button>
                    </fieldset>

                </form>
            </div>


        </div>
    </body>
    </html>