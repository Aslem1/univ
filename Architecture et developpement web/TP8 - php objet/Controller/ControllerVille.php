<?php
chdir(__DIR__);
require("../Model/villeModel.php");
class ControllerVille {

    private villeModel $model;
    /**
     * ControllerVille constructor.
     */
    public function __construct() {
        $this->model = new villeModel();
    }

    public function getAll() {
        return $this->model->findAll();
    }
}
?>
