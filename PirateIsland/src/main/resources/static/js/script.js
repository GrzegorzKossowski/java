var ship = {money:0, beans:0};
var beans = {price:0};

$(document).ready(function(){
    ship.money = parseInt($("#money").val());
    ship.beans = parseInt($("#beans").val());
    beans.price = parseInt($("#beansprice").text());

    $("#ducat").text(ship.money);
    $("#money").val(ship.money);
    $("#beansprice").html(beans.price);
    $("#shipbeansamount").text(ship.beans);

    update();
});

$("#buy").on("click", function() {
    buyProduct();
    update();
});

$("#sell").on("click", function() {
    sellProduct();
    update();
});

function buyProduct() {
    if(ship.money > beans.price) {
        ship.money -= beans.price;
        ship.beans++;
    }    
}

function sellProduct() {
    if(ship.beans > 0) {
        ship.money += beans.price;
        ship.beans--;
    }
 }

function update() {
    $("#money").val(ship.money);
    $("#beans").val(ship.beans);
    $("#ducat").text(ship.money);
    $("#shipbeansamount").text(ship.beans);
};