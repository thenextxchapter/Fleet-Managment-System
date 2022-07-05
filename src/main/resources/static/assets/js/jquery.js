$('document').ready(function () {

    $('#inputCountry').on('change', function () {

        $('#inputState').empty().append('<option value="null">List of States</option>'); // Clear the field

        var countryid = $(this).val(); // capture the selected country id

        // Select the href and receive a single JSON object
        var href = "http://localhost:8080/parameters/country/" + countryid
        $.get(href, function (country, status) {
            var states = country.states;
            for (var i = 0; i <= states.length-1; i++) {
                $('#inputState').append('<option value="' + states[i].id + '">' + states[i].name + '</option>');
            }
        })
    })
})
