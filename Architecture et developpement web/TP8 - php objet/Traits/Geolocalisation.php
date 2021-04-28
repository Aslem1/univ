<?php
trait Geolocalisation{
    private $latitude;
    private $longitude;

    //Getter Latitude
    public function getLatitude() {
        return $this->latitude;
    }

    //Setter Latitude
    public function setLatitude($latitude) {
        $this->latitude = $latitude;
    }

    // ------------------------------------------------
    //Getter Longitude
    public function getLongitude() {
        return $this->longitude;
    }

    //Setter Longitude
    public function setLongitude($longitude) {
        $this->longitude = $longitude;
    }
}
?>