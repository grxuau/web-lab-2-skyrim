    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>LAB2: CHESNOKOV P32111</title>
        <link href = "css/stylesheets/index.css" rel="stylesheet" type="text/css">
    </head>
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
                        <input type="checkbox" id="r1" name="rCoord" value="1" onclick="showCheckedRadius()">
                        <label for="r1">1</label>

                        <input type="checkbox" id="r1.5" name="rCoord" value="1.5" onclick="showCheckedRadius()">
                        <label for="r1.5">1.5</label>

                        <input type="checkbox" id="r2" name="rCoord" value="2" onclick="showCheckedRadius()">
                        <label for="r2">2</label>

                        <input type="checkbox" id="r2.5" name="rCoord" value="2.5" onclick="showCheckedRadius()">
                        <label for="r2.5">2.5</label>

                        <input type="checkbox" id="r3" name="rCoord" value="3" onclick="showCheckedRadius()">
                        <label for="r3">3</label>
                    </fieldset>

                    <fieldset>
                        <legend> Type 'Y' </legend>
                        <input type="text" id="yCoord" name="yCoord" required>
                        <label for="yCoord"></label>
                    </fieldset>

                    <fieldset>
                        <button type="submit"> Fus Ro Dah! </button>
                        <button type="reset"> Krii Lun Aus! </button>
                    </fieldset>
                    <fieldset>
                        <a href="result.jsp">SPELL TOME: REANIMATE CORPSE</a>
                    </fieldset>
                    <fieldset>
                    <div id="error-message"></div>
                    </fieldset>
                </form>
                <noscript>
                        <meta http-equiv="Refresh" content="0; url='./jsnotfound.html'" />
                </noscript>
            </div>
<%--            fixme coordinate plane position is incorrect --%>
            <img class="coordinate-plane" id="coordinate-plane" src="css/multimedia/coord-plane.png" alt="coordinate plane">
            <canvas id="dot-drawer" width="300px" height="360px"></canvas>

            <img id="skyrim-radius-r1" src="css/multimedia/skyrim-radius.png" alt="radius = 1">
            <img id="skyrim-radius-r15" src="css/multimedia/skyrim-radius.png" alt="radius = 1.5">
            <img id="skyrim-radius-r2" src="css/multimedia/skyrim-radius.png" alt="radius = 2">
            <img id="skyrim-radius-r25" src="css/multimedia/skyrim-radius.png" alt="radius = 2.5">
            <img id="skyrim-radius-r3" src="css/multimedia/skyrim-radius.png" alt="radius = 3">
<%--fixme doesn't work properly--%>
<%--            <script type="module">--%>
<%--                import {showCheckedRadius} from './scripts/radius-setter.js'--%>
<%--                showCheckedRadius()--%>
<%--            </script>--%>

        </div>
    </body>
    <script defer src="scripts/jquery-3.6.3.js"></script>
    <script defer src="scripts/validator.js"></script>
    <script defer src="scripts/radius-setter.js"></script>
    <script defer src="scripts/interactive-element.js"></script>
    </html>