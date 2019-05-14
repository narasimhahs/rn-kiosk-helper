using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Kiosk.Helper.RNKioskHelper
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNKioskHelperModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNKioskHelperModule"/>.
        /// </summary>
        internal RNKioskHelperModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNKioskHelper";
            }
        }
    }
}
