$('document').ready(function () {

    $('#inputCountry').on('change', function () {

        $('#inputState').empty().append('<option>List of States</option>'); // Clear the field

        const countryid = $(this).val(); // capture the selected country id

        // Select the href and receive a single JSON object
        const href = "http://localhost:8080/parameters/country/" + countryid;
        $.get(href, function (country, status) {
            const states = country.states;
            for (let i = 0; i <= states.length-1; i++) {
                $('#inputState').append('<option value="' + states[i].id + '">' + states[i].name + '</option>');
            }
        })
    })
})
