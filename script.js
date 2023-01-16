function changeValue(){
    var p = PR.findAll();

    for (let i=0; i<=p.length-1; i++){
        console.log(p[i].getId());
        var x =p[i].getPrice();
        x= x * 4.16;
        p[i].setPrice(x);
        PR.save(p[i])

    }
}
changeValue()