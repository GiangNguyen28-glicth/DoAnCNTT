<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="page-holder bg-gray-100">
    <div class="container-fluid px-lg-4 px-xl-5">
        <!-- Breadcrumbs -->
        <div class="page-breadcrumb">
            <ul class="breadcrumb">
                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                <li class="breadcrumb-item active">Customers </li>
            </ul>
        </div>
        <!-- Page Header-->
        <div class="page-header">
            <h1 class="page-heading">Customers</h1>
            <ul class="list-inline text-sm">
                <li class="list-inline-item"><a class="text-gray-600" href="#!"><i class="fas fa-upload me-2"> </i>Import</a></li>
                <li class="list-inline-item"><a class="text-gray-600" href="#!"><i class="fas fa-download me-2"> </i>Export</a></li>
            </ul>
        </div>
        <div class="card card-table mb-4">
            <div class="card-body">
                <div class="preload-wrapper">
                    <div class="table-responsive">
                        <table class="table table-hover mb-0" id="customersDatatable">
                            <thead>
                            <tr>
                                <th>Customer</th>
                                <th>City</th>
                                <th>Email</th>
                                <th>Phone</th>
                                <th>Status</th>
                                <th>Orders</th>
                                <th>Spent</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr class="align-middle text-muted text-sm">
                                <td class="text-dark text-base" style="min-width: 250px;">
                                    <input class="me-2 mt-3 form-check-input" type="checkbox" id="check0"><a class="text-reset text-decoration-none" href="#!"><span class="avatar p-1 me-2"><span class="avatar-text avatar-primary-light">N</span></span><strong>Nielsen Cobb</strong></a>
                                </td>
                                <td>Graniteville</td>
                                <td>nielsencobb@memora.com</td>
                                <td>+1 (851) 552-2735</td>
                                <td class="text-base"> <span class="badge badge-danger-light">Inactive</span></td>
                                <td>2</td>
                                <td>$460.64</td>
                            </tr>
                            <tr class="align-middle text-muted text-sm">
                                <td class="text-dark text-base" style="min-width: 250px;">
                                    <input class="me-2 mt-3 form-check-input" type="checkbox" id="check1"><a class="text-reset text-decoration-none" href="#!"><img class="avatar p-1 me-2" src="https://d19m59y37dris4.cloudfront.net/bubbly/1-2/img/avatar-1.jpg" alt="Margret Cote"><strong>Margret Cote</strong></a>
                                </td>
                                <td>Foxworth</td>
                                <td>margretcote@zilidium.com</td>
                                <td>+1 (893) 532-2218</td>
                                <td class="text-base"> <span class="badge badge-danger-light">Inactive</span></td>
                                <td>4</td>
                                <td>$360.86</td>
                            </tr>
                            <tr class="align-middle text-muted text-sm">
                                <td class="text-dark text-base" style="min-width: 250px;">
                                    <input class="me-2 mt-3 form-check-input" type="checkbox" id="check2"><a class="text-reset text-decoration-none" href="#!"><img class="avatar p-1 me-2" src="https://d19m59y37dris4.cloudfront.net/bubbly/1-2/img/avatar-2.jpg" alt="Rachel Vinson"><strong>Rachel Vinson</strong></a>
                                </td>
                                <td>Eastmont</td>
                                <td>rachelvinson@chorizon.com</td>
                                <td>+1 (891) 494-2060</td>
                                <td class="text-base"> <span class="badge badge-success-light">Active</span></td>
                                <td>7</td>
                                <td>$250.36</td>
                            </tr>
                            <tr class="align-middle text-muted text-sm">
                                <td class="text-dark text-base" style="min-width: 250px;">
                                    <input class="me-2 mt-3 form-check-input" type="checkbox" id="check3"><a class="text-reset text-decoration-none" href="#!"><span class="avatar p-1 me-2"><span class="avatar-text avatar-warning-light">G</span></span><strong>Gabrielle Aguirre</strong></a>
                                </td>
                                <td>Whitewater</td>
                                <td>gabrielleaguirre@comverges.com</td>
                                <td>+1 (805) 459-3869</td>
                                <td class="text-base"> <span class="badge badge-danger-light">Inactive</span></td>
                                <td>2</td>
                                <td>$690.32</td>
                            </tr>
                            <tr class="align-middle text-muted text-sm">
                                <td class="text-dark text-base" style="min-width: 250px;">
                                    <input class="me-2 mt-3 form-check-input" type="checkbox" id="check4"><a class="text-reset text-decoration-none" href="#!"><img class="avatar p-1 me-2" src="https://d19m59y37dris4.cloudfront.net/bubbly/1-2/img/avatar-4.jpg" alt="Spears Collier"><strong>Spears Collier</strong></a>
                                </td>
                                <td>Hebron</td>
                                <td>spearscollier@remold.com</td>
                                <td>+1 (910) 555-2436</td>
                                <td class="text-base"> <span class="badge badge-danger-light">Inactive</span></td>
                                <td>3</td>
                                <td>$700.99</td>
                            </tr>
                            <tr class="align-middle text-muted text-sm">
                                <td class="text-dark text-base" style="min-width: 250px;">
                                    <input class="me-2 mt-3 form-check-input" type="checkbox" id="check5"><a class="text-reset text-decoration-none" href="#!"><img class="avatar p-1 me-2" src="https://d19m59y37dris4.cloudfront.net/bubbly/1-2/img/avatar-5.jpg" alt="Keisha Thomas"><strong>Keisha Thomas</strong></a>
                                </td>
                                <td>Levant</td>
                                <td>keishathomas@euron.com</td>
                                <td>+1 (958) 405-3392</td>
                                <td class="text-base"> <span class="badge badge-success-light">Active</span></td>
                                <td>12</td>
                                <td>$710.97</td>
                            </tr>
                            <tr class="align-middle text-muted text-sm">
                                <td class="text-dark text-base" style="min-width: 250px;">
                                    <input class="me-2 mt-3 form-check-input" type="checkbox" id="check6"><a class="text-reset text-decoration-none" href="#!"><span class="avatar p-1 me-2"><span class="avatar-text avatar-primary-light">E</span></span><strong>Elisabeth Key</strong></a>
                                </td>
                                <td>Nile</td>
                                <td>elisabethkey@netagy.com</td>
                                <td>+1 (900) 421-2096</td>
                                <td class="text-base"> <span class="badge badge-danger-light">Inactive</span></td>
                                <td>2</td>
                                <td>$550.37</td>
                            </tr>
                            <tr class="align-middle text-muted text-sm">
                                <td class="text-dark text-base" style="min-width: 250px;">
                                    <input class="me-2 mt-3 form-check-input" type="checkbox" id="check7"><a class="text-reset text-decoration-none" href="#!"><img class="avatar p-1 me-2" src="https://d19m59y37dris4.cloudfront.net/bubbly/1-2/img/avatar-7.jpg" alt="Patel Mack"><strong>Patel Mack</strong></a>
                                </td>
                                <td>Albrightsville</td>
                                <td>patelmack@zedalis.com</td>
                                <td>+1 (800) 460-2720</td>
                                <td class="text-base"> <span class="badge badge-danger-light">Inactive</span></td>
                                <td>4</td>
                                <td>$700.22</td>
                            </tr>
                            <tr class="align-middle text-muted text-sm">
                                <td class="text-dark text-base" style="min-width: 250px;">
                                    <input class="me-2 mt-3 form-check-input" type="checkbox" id="check8"><a class="text-reset text-decoration-none" href="#!"><img class="avatar p-1 me-2" src="https://d19m59y37dris4.cloudfront.net/bubbly/1-2/img/avatar-8.jpg" alt="Erika Whitaker"><strong>Erika Whitaker</strong></a>
                                </td>
                                <td>Leola</td>
                                <td>erikawhitaker@uniworld.com</td>
                                <td>+1 (911) 484-3333</td>
                                <td class="text-base"> <span class="badge badge-success-light">Active</span></td>
                                <td>10</td>
                                <td>$80.61</td>
                            </tr>
                            <tr class="align-middle text-muted text-sm">
                                <td class="text-dark text-base" style="min-width: 250px;">
                                    <input class="me-2 mt-3 form-check-input" type="checkbox" id="check9"><a class="text-reset text-decoration-none" href="#!"><span class="avatar p-1 me-2"><span class="avatar-text avatar-warning-light">M</span></span><strong>Meyers Swanson</strong></a>
                                </td>
                                <td>Finderne</td>
                                <td>meyersswanson@candecor.com</td>
                                <td>+1 (999) 404-3297</td>
                                <td class="text-base"> <span class="badge badge-danger-light">Inactive</span></td>
                                <td>5</td>
                                <td>$720.85</td>
                            </tr>
                            <tr class="align-middle text-muted text-sm">
                                <td class="text-dark text-base" style="min-width: 250px;">
                                    <input class="me-2 mt-3 form-check-input" type="checkbox" id="check10"><a class="text-reset text-decoration-none" href="#!"><img class="avatar p-1 me-2" src="https://d19m59y37dris4.cloudfront.net/bubbly/1-2/img/avatar-10.jpg" alt="Townsend Sloan"><strong>Townsend Sloan</strong></a>
                                </td>
                                <td>Coultervillle</td>
                                <td>townsendsloan@rameon.com</td>
                                <td>+1 (978) 563-2964</td>
                                <td class="text-base"> <span class="badge badge-success-light">Active</span></td>
                                <td>10</td>
                                <td>$780.19</td>
                            </tr>
                            <tr class="align-middle text-muted text-sm">
                                <td class="text-dark text-base" style="min-width: 250px;">
                                    <input class="me-2 mt-3 form-check-input" type="checkbox" id="check11"><a class="text-reset text-decoration-none" href="#!"><span class="avatar p-1 me-2"><span class="avatar-text avatar-warning-light">M</span></span><strong>Millicent Henry</strong></a>
                                </td>
                                <td>Caron</td>
                                <td>millicenthenry@balooba.com</td>
                                <td>+1 (863) 585-3988</td>
                                <td class="text-base"> <span class="badge badge-danger-light">Inactive</span></td>
                                <td>11</td>
                                <td>$220.39</td>
                            </tr>
                            <tr class="align-middle text-muted text-sm">
                                <td class="text-dark text-base" style="min-width: 250px;">
                                    <input class="me-2 mt-3 form-check-input" type="checkbox" id="check12"><a class="text-reset text-decoration-none" href="#!"><img class="avatar p-1 me-2" src="https://d19m59y37dris4.cloudfront.net/bubbly/1-2/img/avatar-1.jpg" alt="Madelyn Brock"><strong>Madelyn Brock</strong></a>
                                </td>
                                <td>Ballico</td>
                                <td>madelynbrock@combogene.com</td>
                                <td>+1 (969) 508-2642</td>
                                <td class="text-base"> <span class="badge badge-danger-light">Inactive</span></td>
                                <td>3</td>
                                <td>$350.29</td>
                            </tr>
                            <tr class="align-middle text-muted text-sm">
                                <td class="text-dark text-base" style="min-width: 250px;">
                                    <input class="me-2 mt-3 form-check-input" type="checkbox" id="check13"><a class="text-reset text-decoration-none" href="#!"><img class="avatar p-1 me-2" src="https://d19m59y37dris4.cloudfront.net/bubbly/1-2/img/avatar-2.jpg" alt="Jenkins Carney"><strong>Jenkins Carney</strong></a>
                                </td>
                                <td>Chesterfield</td>
                                <td>jenkinscarney@dadabase.com</td>
                                <td>+1 (901) 471-3581</td>
                                <td class="text-base"> <span class="badge badge-success-light">Active</span></td>
                                <td>8</td>
                                <td>$280.72</td>
                            </tr>
                            <tr class="align-middle text-muted text-sm">
                                <td class="text-dark text-base" style="min-width: 250px;">
                                    <input class="me-2 mt-3 form-check-input" type="checkbox" id="check14"><a class="text-reset text-decoration-none" href="#!"><span class="avatar p-1 me-2"><span class="avatar-text avatar-primary-light">G</span></span><strong>Grimes Delaney</strong></a>
                                </td>
                                <td>Cazadero</td>
                                <td>grimesdelaney@progenex.com</td>
                                <td>+1 (815) 514-2108</td>
                                <td class="text-base"> <span class="badge badge-danger-light">Inactive</span></td>
                                <td>8</td>
                                <td>$460.59</td>
                            </tr>
                            <tr class="align-middle text-muted text-sm">
                                <td class="text-dark text-base" style="min-width: 250px;">
                                    <input class="me-2 mt-3 form-check-input" type="checkbox" id="check15"><a class="text-reset text-decoration-none" href="#!"><img class="avatar p-1 me-2" src="https://d19m59y37dris4.cloudfront.net/bubbly/1-2/img/avatar-4.jpg" alt="Valencia Rivera"><strong>Valencia Rivera</strong></a>
                                </td>
                                <td>Kirk</td>
                                <td>valenciarivera@xleen.com</td>
                                <td>+1 (969) 536-3595</td>
                                <td class="text-base"> <span class="badge badge-success-light">Active</span></td>
                                <td>9</td>
                                <td>$880.00</td>
                            </tr>
                            <tr class="align-middle text-muted text-sm">
                                <td class="text-dark text-base" style="min-width: 250px;">
                                    <input class="me-2 mt-3 form-check-input" type="checkbox" id="check16"><a class="text-reset text-decoration-none" href="#!"><img class="avatar p-1 me-2" src="https://d19m59y37dris4.cloudfront.net/bubbly/1-2/img/avatar-5.jpg" alt="Helene Solomon"><strong>Helene Solomon</strong></a>
                                </td>
                                <td>Riverton</td>
                                <td>helenesolomon@zomboid.com</td>
                                <td>+1 (813) 456-2608</td>
                                <td class="text-base"> <span class="badge badge-success-light">Active</span></td>
                                <td>8</td>
                                <td>$600.14</td>
                            </tr>
                            <tr class="align-middle text-muted text-sm">
                                <td class="text-dark text-base" style="min-width: 250px;">
                                    <input class="me-2 mt-3 form-check-input" type="checkbox" id="check17"><a class="text-reset text-decoration-none" href="#!"><span class="avatar p-1 me-2"><span class="avatar-text avatar-warning-light">K</span></span><strong>Kathleen Holman</strong></a>
                                </td>
                                <td>Darlington</td>
                                <td>kathleenholman@hotcakes.com</td>
                                <td>+1 (857) 406-2766</td>
                                <td class="text-base"> <span class="badge badge-success-light">Active</span></td>
                                <td>12</td>
                                <td>$280.63</td>
                            </tr>
                            <tr class="align-middle text-muted text-sm">
                                <td class="text-dark text-base" style="min-width: 250px;">
                                    <input class="me-2 mt-3 form-check-input" type="checkbox" id="check18"><a class="text-reset text-decoration-none" href="#!"><img class="avatar p-1 me-2" src="https://d19m59y37dris4.cloudfront.net/bubbly/1-2/img/avatar-7.jpg" alt="Merrill Garrett"><strong>Merrill Garrett</strong></a>
                                </td>
                                <td>Utting</td>
                                <td>merrillgarrett@affluex.com</td>
                                <td>+1 (996) 557-2069</td>
                                <td class="text-base"> <span class="badge badge-danger-light">Inactive</span></td>
                                <td>10</td>
                                <td>$390.42</td>
                            </tr>
                            <tr class="align-middle text-muted text-sm">
                                <td class="text-dark text-base" style="min-width: 250px;">
                                    <input class="me-2 mt-3 form-check-input" type="checkbox" id="check19"><a class="text-reset text-decoration-none" href="#!"><img class="avatar p-1 me-2" src="https://d19m59y37dris4.cloudfront.net/bubbly/1-2/img/avatar-8.jpg" alt="Sallie Booth"><strong>Sallie Booth</strong></a>
                                </td>
                                <td>Waiohinu</td>
                                <td>salliebooth@ziggles.com</td>
                                <td>+1 (874) 556-2181</td>
                                <td class="text-base"> <span class="badge badge-danger-light">Inactive</span></td>
                                <td>2</td>
                                <td>$130.43</td>
                            </tr>
                            </tbody>
                        </table>
                    </div><span class="me-2" id="categoryBulkAction">
                  <select class="form-select form-select-sm d-inline w-auto" name="categoryBulkAction">
                    <option>Bulk Actions</option>
                    <option>Delete</option>
                  </select>
                  <button class="btn btn-sm btn-outline-primary align-top">Apply</button></span>
                </div>
            </div>
        </div>
    </div>
</div>
