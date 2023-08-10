#menu2 {
    border-left: 10px solid black;
}

#menu2 a {
    display: block;
    color: #fff;
}

.M01 {
    margin-left: 20px;
    width: 100px;
    background: #000;
}

.M01>li, .M02>li, .M03>li {
    position: relative;
    width: 100%;
    height: 50px;
    background: #000;
    text-align: center;
    line-height: 50px;
}

.M01>li:hover .M02 {
    left: 100px;
}

.M01>li a:hover {
    display: block;
    background: #AB06AD;
}

.M02, .M03 {
    width: 100px;
    background: black;
    position: absolute;
    top: 0;
    left: -9999px;
}

.M02>li:hover .M03 {
    left: 100px;
}

.M02>li a:hover {
    display: block;
    background: red;
}

.M03>li a:hover {
    display: block;
    background: blue;
}