function myFunction(mausac) {
    // Get the checkbox
    var checkBox = document.getElementById(mausac);
    // Get the output text
    var text = document.getElementById("text" + mausac);
    var object = [
        {
            "id" : 28,
            "ten" : 'xanh'
        },
        {
            "id" : 29,
            "ten" : 'đỏ'
        }
    ]
    // If the checkbox is checked, display the output text
    if (checkBox.checked == true){
        for (let i = 0; i < object.length; i++) {
            if (object[i].id === mausac){
                text.innerHTML += '<div><label>Số lượng '+ object[i].ten +'</label>Size 28 <input style="width: 30px">Size 29 <input style="width: 30px"></div>';
            }
        }


    } else {
        text.innerHTML = '';
    }
}
var loadFile = function(event) {
    var output = document.getElementById('output');
    output.src = URL.createObjectURL(event.target.files[0]);
    output.onload = function() {
        URL.revokeObjectURL(output.src) // free memory
    }
};
