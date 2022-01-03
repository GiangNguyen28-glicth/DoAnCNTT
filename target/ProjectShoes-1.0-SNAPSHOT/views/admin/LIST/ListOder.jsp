<div class="sidebar py-3" id="sidebar">
    <h6 class="sidebar-heading">Main</h6>
    <ul class="list-unstyled">
        <li class="sidebar-list-item"><a class="sidebar-link text-muted" href="/admin-home">
            <svg class="svg-icon svg-icon-md me-3">
                <use xlink:href="icons/orion-svg-sprite.57a86639.svg#real-estate-1"> </use>
            </svg><span class="sidebar-link-title">Dashboard</span></a></li>
        <li class="sidebar-list-item"><a class="sidebar-link text-muted " href="#" data-bs-target="#cmsDropdown" role="button" aria-expanded="false" data-bs-toggle="collapse">
            <svg class="svg-icon svg-icon-md me-3">
                <use xlink:href="icons/orion-svg-sprite.57a86639.svg#reading-1"> </use>
            </svg><span class="sidebar-link-title">CMS </span></a>
            <ul class="sidebar-menu list-unstyled collapse " id="cmsDropdown">
                <li class="sidebar-list-item"><a class="sidebar-link text-muted" href="cms-post.html">Posts</a></li>
                <li class="sidebar-list-item"><a class="sidebar-link text-muted" href="cms-post-new.html">Add new post</a></li>
                <li class="sidebar-list-item"><a class="sidebar-link text-muted" href="/admin-category">Categories</a></li>
                <li class="sidebar-list-item"><a class="sidebar-link text-muted" href="cms-media.html">Media library</a></li>
            </ul>
        </li>
        <li class="sidebar-list-item"><a class="sidebar-link text-muted " href="#" data-bs-target="#widgetsDropdown" role="button" aria-expanded="false" data-bs-toggle="collapse">
            <svg class="svg-icon svg-icon-md me-3">
                <use xlink:href="icons/orion-svg-sprite.57a86639.svg#statistic-1"> </use>
            </svg><span class="sidebar-link-title">Widgets </span></a>
            <ul class="sidebar-menu list-unstyled collapse " id="widgetsDropdown">
                <li class="sidebar-list-item"><a class="sidebar-link text-muted" href="widgets-stats.html">Stats</a></li>
                <li class="sidebar-list-item"><a class="sidebar-link text-muted" href="widgets-data.html">Data</a></li>
            </ul>
        </li>
        <li class="sidebar-list-item"><a class="sidebar-link text-muted active" href="#" data-bs-target="#e-commerceDropdown" role="button" aria-expanded="true" data-bs-toggle="collapse">
            <svg class="svg-icon svg-icon-md me-3">
                <use xlink:href="icons/orion-svg-sprite.57a86639.svg#delivery-truck-1"> </use>
            </svg><span class="sidebar-link-title">E-commerce </span></a>
            <ul class="sidebar-menu list-unstyled collapse show" id="e-commerceDropdown">
                <li class="sidebar-list-item"><a class="sidebar-link active text-muted" href="/admin-product">Products</a></li>
                <li class="sidebar-list-item"><a class="sidebar-link text-muted" href="/admin-product?action=insert">Products - New</a></li>
                <li class="sidebar-list-item"><a class="sidebar-link text-muted" href="e-commerce-orders.html">Orders</a></li>
                <li class="sidebar-list-item"><a class="sidebar-link text-muted" href="e-commerce-order.html">Order - Detail</a></li>
                <li class="sidebar-list-item"><a class="sidebar-link text-muted" href="e-commerce-customers.html">Customers</a></li>
            </ul>
        </li>
        <li class="sidebar-list-item"><a class="sidebar-link text-muted " href="#" data-bs-target="#userDropdown" role="button" aria-expanded="false" data-bs-toggle="collapse">
            <svg class="svg-icon svg-icon-md me-3">
                <use xlink:href="icons/orion-svg-sprite.57a86639.svg#man-1"> </use>
            </svg><span class="sidebar-link-title">User </span></a>
            <ul class="sidebar-menu list-unstyled collapse " id="userDropdown">
                <li class="sidebar-list-item"><a class="sidebar-link text-muted" href="login.html">Login page</a></li>
                <li class="sidebar-list-item"><a class="sidebar-link text-muted" href="register.html">Register</a></li>
                <li class="sidebar-list-item"><a class="sidebar-link text-muted" href="login-2.html">Login v.2 <span class="badge bg-info ms-2 text-decoration-none">New</span></a></li>
                <li class="sidebar-list-item"><a class="sidebar-link text-muted" href="register-2.html">Register v.2 <span class="badge bg-info ms-2 text-decoration-none">New</span></a></li>
            </ul>
        </li>
    </ul>
</div>
<div class="page-breadcrumb">
    <ul class="breadcrumb">
        <li class="breadcrumb-item"><a href="index.html">Home</a></li>
        <li class="breadcrumb-item active">Orders</li>
    </ul>
</div>
<!-- Page Header-->
<div class="page-header">
    <h1 class="page-heading">Orders</h1>
    <ul class="list-inline text-sm">
        <li class="list-inline-item"><a class="text-gray-600" href="#!"><i
                class="fas fa-upload me-2"> </i>Import</a></li>
        <li class="list-inline-item"><a class="text-gray-600" href="#!"><i
                class="fas fa-download me-2"> </i>Export</a></li>
    </ul>
</div>
<div class="card card-table mb-4">
    <div class="card-body">
        <div class="preload-wrapper">
            <div class="table-responsive">
                <table class="table table-hover mb-0" id="ordersDatatable">
                    <thead>
                    <tr>
                        <th>Order Id</th>
                        <th>Name</th>
                        <th>Date</th>
                        <th>Total Price</th>
                        <th>Status</th>
                        <th>Review</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="align-middle">
                        <td> <span class="form-check">
                            <input class="form-check-input" type="checkbox" id="check0">
                            <label class="form-check-label" for="check0">#2458</label></span></td>
                        <td><strong>Nielsen Cobb</strong><br><span class="text-muted text-sm">nielsencobb@memora.com</span>
                        </td>
                        <td>2021/02/24</td>
                        <td>$720.43</td>
                        <td><span class="badge badge-success-light">Open</span></td>
                        <td class="text-end" style="min-width: 125px;"><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a>
                            <a
                                    href="#!"><i class="fa fa-star text-gray-500"></i></a>
                        </td>
                    </tr>
                    <tr class="align-middle">
                        <td> <span class="form-check">
                            <input class="form-check-input" type="checkbox" id="check1">
                            <label class="form-check-label" for="check1">#2459</label></span></td>
                        <td><strong>Margret Cote</strong><br><span class="text-muted text-sm">margretcote@zilidium.com</span>
                        </td>
                        <td>2021/07/16</td>
                        <td>$530.39</td>
                        <td><span class="badge badge-danger-light">Closed</span></td>
                        <td class="text-end" style="min-width: 125px;"><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a>
                            <a
                                    href="#!"><i class="fa fa-star text-gray-500"></i></a>
                        </td>
                    </tr>
                    <tr class="align-middle">
                        <td> <span class="form-check">
                            <input class="form-check-input" type="checkbox" id="check2">
                            <label class="form-check-label" for="check2">#2460</label></span></td>
                        <td><strong>Rachel Vinson</strong><br><span class="text-muted text-sm">rachelvinson@chorizon.com</span>
                        </td>
                        <td>2021/06/13</td>
                        <td>$300.70</td>
                        <td><span class="badge badge-warning-light">On Hold</span></td>
                        <td class="text-end" style="min-width: 125px;"><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a>
                            <a
                                    href="#!"><i class="fa fa-star text-gray-500"></i></a>
                        </td>
                    </tr>
                    <tr class="align-middle">
                        <td> <span class="form-check">
                            <input class="form-check-input" type="checkbox" id="check3">
                            <label class="form-check-label" for="check3">#2461</label></span></td>
                        <td><strong>Gabrielle Aguirre</strong><br><span class="text-muted text-sm">gabrielleaguirre@comverges.com</span>
                        </td>
                        <td>2021/02/05</td>
                        <td>$460.60</td>
                        <td><span class="badge badge-info-light">In Progress</span></td>
                        <td class="text-end" style="min-width: 125px;"><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a>
                            <a
                                    href="#!"><i class="fa fa-star text-gray-500"></i></a>
                        </td>
                    </tr>
                    <tr class="align-middle">
                        <td> <span class="form-check">
                            <input class="form-check-input" type="checkbox" id="check4">
                            <label class="form-check-label" for="check4">#2462</label></span></td>
                        <td><strong>Spears Collier</strong><br><span class="text-muted text-sm">spearscollier@remold.com</span>
                        </td>
                        <td>2021/11/04</td>
                        <td>$20.87</td>
                        <td><span class="badge badge-success-light">Open</span></td>
                        <td class="text-end" style="min-width: 125px;"><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a>
                            <a
                                    href="#!"><i class="fa fa-star text-gray-500"></i></a>
                        </td>
                    </tr>
                    <tr class="align-middle">
                        <td> <span class="form-check">
                            <input class="form-check-input" type="checkbox" id="check5">
                            <label class="form-check-label" for="check5">#2463</label></span></td>
                        <td><strong>Keisha Thomas</strong><br><span class="text-muted text-sm">keishathomas@euron.com</span>
                        </td>
                        <td>2021/12/21</td>
                        <td>$360.73</td>
                        <td><span class="badge badge-danger-light">Closed</span></td>
                        <td class="text-end" style="min-width: 125px;"><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a>
                            <a
                                    href="#!"><i class="fa fa-star text-gray-500"></i></a>
                        </td>
                    </tr>
                    <tr class="align-middle">
                        <td> <span class="form-check">
                            <input class="form-check-input" type="checkbox" id="check6">
                            <label class="form-check-label" for="check6">#2464</label></span></td>
                        <td><strong>Elisabeth Key</strong><br><span class="text-muted text-sm">elisabethkey@netagy.com</span>
                        </td>
                        <td>2021/12/06</td>
                        <td>$320.51</td>
                        <td><span class="badge badge-warning-light">On Hold</span></td>
                        <td class="text-end" style="min-width: 125px;"><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a>
                            <a
                                    href="#!"><i class="fa fa-star text-gray-500"></i></a>
                        </td>
                    </tr>
                    <tr class="align-middle">
                        <td> <span class="form-check">
                            <input class="form-check-input" type="checkbox" id="check7">
                            <label class="form-check-label" for="check7">#2465</label></span></td>
                        <td><strong>Patel Mack</strong><br><span class="text-muted text-sm">patelmack@zedalis.com</span>
                        </td>
                        <td>2021/08/27</td>
                        <td>$750.35</td>
                        <td><span class="badge badge-info-light">In Progress</span></td>
                        <td class="text-end" style="min-width: 125px;"><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a>
                            <a
                                    href="#!"><i class="fa fa-star text-gray-500"></i></a>
                        </td>
                    </tr>
                    <tr class="align-middle">
                        <td> <span class="form-check">
                            <input class="form-check-input" type="checkbox" id="check8">
                            <label class="form-check-label" for="check8">#2466</label></span></td>
                        <td><strong>Erika Whitaker</strong><br><span class="text-muted text-sm">erikawhitaker@uniworld.com</span>
                        </td>
                        <td>2021/01/23</td>
                        <td>$440.23</td>
                        <td><span class="badge badge-success-light">Open</span></td>
                        <td class="text-end" style="min-width: 125px;"><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a>
                            <a
                                    href="#!"><i class="fa fa-star text-gray-500"></i></a>
                        </td>
                    </tr>
                    <tr class="align-middle">
                        <td> <span class="form-check">
                            <input class="form-check-input" type="checkbox" id="check9">
                            <label class="form-check-label" for="check9">#2467</label></span></td>
                        <td><strong>Meyers Swanson</strong><br><span class="text-muted text-sm">meyersswanson@candecor.com</span>
                        </td>
                        <td>2021/08/28</td>
                        <td>$210.32</td>
                        <td><span class="badge badge-danger-light">Closed</span></td>
                        <td class="text-end" style="min-width: 125px;"><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a>
                            <a
                                    href="#!"><i class="fa fa-star text-gray-500"></i></a>
                        </td>
                    </tr>
                    <tr class="align-middle">
                        <td> <span class="form-check">
                            <input class="form-check-input" type="checkbox" id="check10">
                            <label class="form-check-label" for="check10">#2468</label></span></td>
                        <td><strong>Townsend Sloan</strong><br><span class="text-muted text-sm">townsendsloan@rameon.com</span>
                        </td>
                        <td>2021/07/27</td>
                        <td>$820.31</td>
                        <td><span class="badge badge-warning-light">On Hold</span></td>
                        <td class="text-end" style="min-width: 125px;"><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a>
                            <a
                                    href="#!"><i class="fa fa-star text-gray-500"></i></a>
                        </td>
                    </tr>
                    <tr class="align-middle">
                        <td> <span class="form-check">
                            <input class="form-check-input" type="checkbox" id="check11">
                            <label class="form-check-label" for="check11">#2469</label></span></td>
                        <td><strong>Millicent Henry</strong><br><span class="text-muted text-sm">millicenthenry@balooba.com</span>
                        </td>
                        <td>2021/03/19</td>
                        <td>$300.61</td>
                        <td><span class="badge badge-info-light">In Progress</span></td>
                        <td class="text-end" style="min-width: 125px;"><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a>
                            <a
                                    href="#!"><i class="fa fa-star text-gray-500"></i></a>
                        </td>
                    </tr>
                    <tr class="align-middle">
                        <td> <span class="form-check">
                            <input class="form-check-input" type="checkbox" id="check12">
                            <label class="form-check-label" for="check12">#2470</label></span></td>
                        <td><strong>Madelyn Brock</strong><br><span class="text-muted text-sm">madelynbrock@combogene.com</span>
                        </td>
                        <td>2021/09/26</td>
                        <td>$190.96</td>
                        <td><span class="badge badge-success-light">Open</span></td>
                        <td class="text-end" style="min-width: 125px;"><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a>
                            <a
                                    href="#!"><i class="fa fa-star text-gray-500"></i></a>
                        </td>
                    </tr>
                    <tr class="align-middle">
                        <td> <span class="form-check">
                            <input class="form-check-input" type="checkbox" id="check13">
                            <label class="form-check-label" for="check13">#2471</label></span></td>
                        <td><strong>Jenkins Carney</strong><br><span class="text-muted text-sm">jenkinscarney@dadabase.com</span>
                        </td>
                        <td>2021/03/12</td>
                        <td>$500.02</td>
                        <td><span class="badge badge-danger-light">Closed</span></td>
                        <td class="text-end" style="min-width: 125px;"><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a>
                            <a
                                    href="#!"><i class="fa fa-star text-gray-500"></i></a>
                        </td>
                    </tr>
                    <tr class="align-middle">
                        <td> <span class="form-check">
                            <input class="form-check-input" type="checkbox" id="check14">
                            <label class="form-check-label" for="check14">#2472</label></span></td>
                        <td><strong>Grimes Delaney</strong><br><span class="text-muted text-sm">grimesdelaney@progenex.com</span>
                        </td>
                        <td>2021/09/13</td>
                        <td>$290.67</td>
                        <td><span class="badge badge-warning-light">On Hold</span></td>
                        <td class="text-end" style="min-width: 125px;"><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a>
                            <a
                                    href="#!"><i class="fa fa-star text-gray-500"></i></a>
                        </td>
                    </tr>
                    <tr class="align-middle">
                        <td> <span class="form-check">
                            <input class="form-check-input" type="checkbox" id="check15">
                            <label class="form-check-label" for="check15">#2473</label></span></td>
                        <td><strong>Valencia Rivera</strong><br><span class="text-muted text-sm">valenciarivera@xleen.com</span>
                        </td>
                        <td>2021/02/31</td>
                        <td>$430.68</td>
                        <td><span class="badge badge-info-light">In Progress</span></td>
                        <td class="text-end" style="min-width: 125px;"><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a>
                            <a
                                    href="#!"><i class="fa fa-star text-gray-500"></i></a>
                        </td>
                    </tr>
                    <tr class="align-middle">
                        <td> <span class="form-check">
                            <input class="form-check-input" type="checkbox" id="check16">
                            <label class="form-check-label" for="check16">#2474</label></span></td>
                        <td><strong>Helene Solomon</strong><br><span class="text-muted text-sm">helenesolomon@zomboid.com</span>
                        </td>
                        <td>2021/03/26</td>
                        <td>$480.14</td>
                        <td><span class="badge badge-success-light">Open</span></td>
                        <td class="text-end" style="min-width: 125px;"><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a>
                            <a
                                    href="#!"><i class="fa fa-star text-gray-500"></i></a>
                        </td>
                    </tr>
                    <tr class="align-middle">
                        <td> <span class="form-check">
                            <input class="form-check-input" type="checkbox" id="check17">
                            <label class="form-check-label" for="check17">#2475</label></span></td>
                        <td><strong>Kathleen Holman</strong><br><span class="text-muted text-sm">kathleenholman@hotcakes.com</span>
                        </td>
                        <td>2021/05/08</td>
                        <td>$860.47</td>
                        <td><span class="badge badge-danger-light">Closed</span></td>
                        <td class="text-end" style="min-width: 125px;"><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a>
                            <a
                                    href="#!"><i class="fa fa-star text-gray-500"></i></a>
                        </td>
                    </tr>
                    <tr class="align-middle">
                        <td> <span class="form-check">
                            <input class="form-check-input" type="checkbox" id="check18">
                            <label class="form-check-label" for="check18">#2476</label></span></td>
                        <td><strong>Merrill Garrett</strong><br><span class="text-muted text-sm">merrillgarrett@affluex.com</span>
                        </td>
                        <td>2021/10/06</td>
                        <td>$560.41</td>
                        <td><span class="badge badge-warning-light">On Hold</span></td>
                        <td class="text-end" style="min-width: 125px;"><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a>
                            <a
                                    href="#!"><i class="fa fa-star text-gray-500"></i></a>
                        </td>
                    </tr>
                    <tr class="align-middle">
                        <td> <span class="form-check">
                            <input class="form-check-input" type="checkbox" id="check19">
                            <label class="form-check-label" for="check19">#2477</label></span></td>
                        <td><strong>Sallie Booth</strong><br><span class="text-muted text-sm">salliebooth@ziggles.com</span>
                        </td>
                        <td>2021/11/07</td>
                        <td>$50.43</td>
                        <td><span class="badge badge-info-light">In Progress</span></td>
                        <td class="text-end" style="min-width: 125px;"><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a><a href="#!"><i
                                class="fa fa-star text-warning"></i></a>
                            <a
                                    href="#!"><i class="fa fa-star text-gray-500"></i></a>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <span class="me-2" id="categoryBulkAction">
                  <select class="form-select form-select-sm d-inline w-auto"
                          name="categoryBulkAction">
                    <option>Bulk Actions</option>
                    <option>Delete</option>
                  </select>
                  <button class="btn btn-sm btn-outline-primary align-top">Apply</button></span>
        </div>
    </div>
</div>