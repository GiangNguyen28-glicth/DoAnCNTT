<header class="header">
    <nav class="navbar navbar-expand-lg px-4 py-2 bg-white shadow"><a class="sidebar-toggler text-gray-500 me-4 me-lg-5 lead" href="#"><i class="fas fa-align-left"></i></a><a class="navbar-brand fw-bold text-uppercase text-base" href="#"><span class="d-none d-brand-partial">Bubbly </span><span class="d-none d-sm-inline">Dashboard</span></a>
        <ul class="ms-auto d-flex align-items-center list-unstyled mb-0">
            <li class="nav-item dropdown me-2"><a class="nav-link nav-link-icon text-gray-400 px-1" id="notifications" href="#" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>
                <div class="dropdown-menu dropdown-menu-end dropdown-menu-animated text-sm" aria-labelledby="notifications">
                    <a class="dropdown-item" href="#">
                        <div class="d-flex align-items-center">
                            <div class="icon icon-sm bg-indigo text-white"><i class="fab fa-twitter"></i></div>
                            <div class="text ms-2">
                                <p class="mb-0">You have 2 followers</p>
                            </div>
                        </div>
                    </a>
                    <a class="dropdown-item" href="#">
                        <div class="d-flex align-items-center">
                            <div class="icon icon-sm bg-green text-white"><i class="fas fa-envelope"></i></div>
                            <div class="text ms-2">
                                <p class="mb-0">You have 6 new messages</p>
                            </div>
                        </div>
                    </a>
                    <a class="dropdown-item" href="#">
                        <div class="d-flex align-items-center">
                            <div class="icon icon-sm bg-blue text-white"><i class="fas fa-upload"></i></div>
                            <div class="text ms-2">
                                <p class="mb-0">Server rebooted</p>
                            </div>
                        </div>
                    </a>
                    <a class="dropdown-item" href="#">
                        <div class="d-flex align-items-center">
                            <div class="icon icon-sm bg-indigo text-white"><i class="fab fa-twitter"></i></div>
                            <div class="text ms-2">
                                <p class="mb-0">You have 2 followers</p>
                            </div>
                        </div>
                    </a>
                    <div class="dropdown-divider"></div><a class="dropdown-item text-center" href="#"><small class="fw-bold text-uppercase">View all notifications</small></a>
                </div>
            </li>
            <!-- Messages                        -->
            <li class="nav-item dropdown me-2 me-lg-3"> <a class="nav-link nav-link-icon text-gray-400 px-1" id="messages" href="#" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>
                <div class="dropdown-menu dropdown-menu-end dropdown-menu-animated text-sm" aria-labelledby="messages"><a class="dropdown-item d-flex align-items-center p-3" href="#"> <img class="avatar avatar-sm p-1 me-2" src="https://d19m59y37dris4.cloudfront.net/bubbly/1-2/img/avatar-0.jpg" alt="Jason Doe">
                    <div class="pt-1">
                        <h6 class="fw-bold mb-0">Jason Doe</h6><span class="text-muted text-sm">Sent you a message</span>
                    </div></a><a class="dropdown-item d-flex align-items-center p-3" href="#"> <img class="avatar avatar-sm p-1 me-2" src="https://d19m59y37dris4.cloudfront.net/bubbly/1-2/img/avatar-1.jpg" alt="Frank Williams">
                    <div class="pt-1">
                        <h6 class="fw-bold mb-0">Frank Williams</h6><span class="text-muted text-sm">Sent you a message</span>
                    </div></a><a class="dropdown-item d-flex align-items-center p-3" href="#"> <img class="avatar avatar-sm p-1 me-2" src="https://d19m59y37dris4.cloudfront.net/bubbly/1-2/img/avatar-2.jpg" alt="Ashley Wood">
                    <div class="pt-1">
                        <h6 class="fw-bold mb-0">Ashley Wood</h6><span class="text-muted text-sm">Sent you a message</span>
                    </div></a>
                    <div class="dropdown-divider"></div><a class="dropdown-item text-center" href="#"> <small class="fw-bold text-uppercase">View all messages                          </small></a>
                </div>
            </li>
            <li class="nav-item dropdown ms-auto"><a class="nav-link pe-0" id="userInfo" href="#" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><img class="avatar p-1" src="https://d19m59y37dris4.cloudfront.net/bubbly/1-2/img/avatar-6.jpg" alt="Jason Doe"></a>
                <div class="dropdown-menu dropdown-menu-end dropdown-menu-animated" aria-labelledby="userInfo">
                    <div class="dropdown-header text-gray-700">
                        <h6 class="text-uppercase font-weight-bold">Mark Stephen</h6><small>Web Developer</small>
                    </div>
                    <div class="dropdown-divider"></div><a class="dropdown-item" href="${pageContext.request.contextPath}/thoat?action=logout">Logout</a>
                </div>
            </li>
        </ul>
    </nav>
</header>