<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class DefaultController extends AbstractController
{
    /**
     * @Route("/test/validation", name="homepage")
     */
    public function index(): Response
    {
        return $this->render('default/index.html.twig', [
            'controller_name' => 'variableAAfficher',
        ]);
    }
    /**
     * @Route("/produits/{id}",requirements={"id": "[1-9]\d*"}, name="produits")
     */
    public function produits(): Response
    {
        return $this->render('default/produits.html.twig', [
            'controller_name' => 'variableAAfficher',
        ]);
    }
}
