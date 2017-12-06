var map = null;
var marker = null;
var default_lat = 12.879721;
var default_lng = 121.7740169;
var default_zoom = 10;
var map_div = "map_canvas";
// some google objects
var infowindow = new google.maps.InfoWindow();
var geocoder = new google.maps.Geocoder();

$(document).ready(function() {
    $("#frm_show_address").submit(function() {
        var street_address = $("#street_address").val();
        if(street_address.length > 0 ){
            // display code address
            showAddress(street_address);
        }
        
        return false;
    });

});

function initialize(lat, lng) {

	if(lat!=null && lng!=null)
	{
		default_lat = lat;
		default_lng = lng;
	}
	
    var latlng = new google.maps.LatLng(default_lat, default_lng);

    var mapOptions = {
        scaleControl: true,
        zoom: default_zoom,
        zoomControl: true,
        center: latlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP,
        draggableCursor: 'crosshair'
    };

    map = new google.maps.Map(document.getElementById(map_div), mapOptions);

    showMarker();
}

function showMarker(){
    // remove all markers
    remove_all_markers();   
     
    marker = new google.maps.Marker({
            position: map.getCenter(),
            map: map,
//            title: arr_markers[marker_index]["name"],
            draggable: true
    });
    
    build_info_window();

    google.maps.event.addListener(marker, 'click', function(event) {
        build_info_window();
    });
    
    google.maps.event.addListener(marker, "dragend", function() {
        build_info_window();
    });
    
}

function show_infoWindow(sea_level){

    infowindow.setContent( '<div class="googleMap_infowindow">'
+'<span class="info_details"><strong>Drag marker to required location.</strong></span>'
+ '<span class="info_details">Latitude:</span><span class="info_details"> <input type="text" value="'+ marker.getPosition().lat() + '"/></span>'
+ '<span class="info_details">Longitude:</span><span class="info_details"> <input type="text" value="'+ marker.getPosition().lng() + '"/></span></div>'
 );
    
    infowindow.open(map,marker);
        
}

function remove_all_markers(){
    if(marker != null){
       marker.setMap(null); 
    }      
}

function build_info_window() {

var sea_level;

    $.ajax({
        url: "coordinates/mapcoordinates.php",
        type: "POST",
        dataType: 'html',
        data: {
            lat: marker.getPosition().lat(),
            lng: marker.getPosition().lng()
        },
        success: function(respText) {
            if (respText == '-9999') {
                sea_level = '';
            } else if (respText.match('Error: the free servers are currently overloaded with requests.')) {
                sea_level = '';
            } else {
                sea_level = respText + ' m';
            }
        },
        complete: function() {
            show_infoWindow(sea_level);
        }
    });
}

function showAddress(address) {

    geocoder.geocode( { 'address': address}, function(results, status) {
       
        if (status == google.maps.GeocoderStatus.OK) {
            // remove all markers
            remove_all_markers();
            
            map.setCenter(results[0].geometry.location);
            map.setZoom(13);

            showMarker();

        } else {
          alert(address + " not found");
        }
    });

}

function getLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPosition);
    } else {
        alert("Geolocation is not supported by this browser.");
    }
}

function showPosition(position) {
    var latlng = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);

    var mapOptions = {
        scaleControl: true,
        zoom: default_zoom,
        zoomControl: true,
        center: latlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP,
        draggableCursor: 'crosshair'
    };

    map = new google.maps.Map(document.getElementById(map_div), mapOptions);

    showMarker();
}